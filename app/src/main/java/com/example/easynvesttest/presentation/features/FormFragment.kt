package com.example.easynvesttest.presentation.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.concrete.canarinho.watcher.MascaraNumericaTextWatcher
import br.com.concrete.canarinho.watcher.ValorMonetarioWatcher
import com.example.easynvesttest.R
import com.example.easynvesttest.domain.request.ParametersRequest
import com.example.easynvesttest.extensions.filterDigits
import com.example.easynvesttest.presentation.features.viewmodel.SimulatorCalculatorViewModel
import kotlinx.android.synthetic.main.fragment_form.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder

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
        setupObservers()
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

        text_date_application.addTextChangedListener(
            MascaraNumericaTextWatcher.Builder()
            .paraMascara("##/##/####")
            .build())

        button_simulate.setOnClickListener {
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

            viewModel.calculatorInvestment()
        }
    }

    private fun setupObservers() {
        viewModel.navigateToResultAction.observe(viewLifecycleOwner) {
            it.getContentIfNotHandled()?.let {
                findNavController().navigate(R.id.to_resultFragment)
            }
        }

        viewModel.errorLiveData.observe(viewLifecycleOwner) {
            showDialogError()
        }

        viewModel.loadingLiveData.observe(viewLifecycleOwner) {
            progress.isVisible = it
        }
    }

    private fun showDialogError() {
       MaterialAlertDialogBuilder(requireContext())
           .setMessage(R.string.loading_error)
           .setPositiveButton("Ok", null)
           .show()
    }
}