package com.example.easynvesttest.presentation.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.easynvesttest.R
import com.example.easynvesttest.presentation.features.viewmodel.SimulatorCalculatorViewModel
import kotlinx.android.synthetic.main.fragment_result.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ResultFragment : Fragment() {
   private val viewModel: SimulatorCalculatorViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    private fun setupObservers() {
        viewModel.facilitatorInvestment().observeForever {
            text_result_simulate.text = it.grossAmount.toString()
        }
    }
}