package com.example.easynvesttest.presentation.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import br.com.concrete.canarinho.watcher.ValorMonetarioWatcher
import com.example.easynvesttest.R
import com.example.easynvesttest.domain.request.ParametersRequest
import com.example.easynvesttest.extensions.filterDigits
import com.example.easynvesttest.presentation.features.viewmodel.SimulatorCalculatorViewModel
import com.example.easynvesttest.util.DateTimeFormat
import kotlinx.android.synthetic.main.fragment_form.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class FormFragment : Fragment() {
    private val viewModel: SimulatorCalculatorViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_form, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
       text_value_application.apply {
            text?.clear()
            addTextChangedListener(
                ValorMonetarioWatcher.Builder()
                    .comSimboloReal()
                    .build()
            )
        }

        text_rate_application.apply {
            text?.clear()
            addTextChangedListener(ValorMonetarioWatcher())
        }


        button_simulate.setOnClickListener {
            it.findNavController().navigate(R.id.to_resultFragment)

            val investedAmount = text_value_application.text.toString()
            val maturityDate = text_date_application.text.toString()
            val rate = text_rate_application.text.toString()

            viewModel.setParameters(
                ParametersRequest(
                    investedAmount = investedAmount.filterDigits(),
                    maturityDate = maturityDate,
                    rate = rate.filterDigits(),
                )
            )
        }
    }
}