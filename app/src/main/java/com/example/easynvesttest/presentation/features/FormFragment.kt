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
import com.example.easynvesttest.databinding.FragmentFormBinding
import com.example.easynvesttest.domain.request.ParametersRequest
import com.example.easynvesttest.extensions.filterDouble
import com.example.easynvesttest.extensions.getDateOrNull
import com.example.easynvesttest.presentation.features.viewmodel.SimulatorCalculatorViewModel
import com.example.easynvesttest.util.DateTimeFormat
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.fragment_form.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FormFragment : Fragment() {
    private val viewModel: SimulatorCalculatorViewModel by sharedViewModel()

    private var _binding: FragmentFormBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFormBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupObservers()
    }

    private fun setupView() {
        binding.investedAmount.apply {
            text?.clear()
            addTextChangedListener(
                ValorMonetarioWatcher.Builder()
                    .comSimboloReal()
                    .build()
            )
        }

        binding.rate.apply {
            text?.clear()
            addTextChangedListener(ValorMonetarioWatcher())
        }

        binding.maturityDate.addTextChangedListener(
            MascaraNumericaTextWatcher.Builder()
                .paraMascara("##/##/####")
                .build()
        )

        simulate.setOnClickListener {
           val investedAmount = binding.investedAmount.text.toString().filterDouble()
           val maturityDate = binding.maturityDate.text.toString().getDateOrNull()
           val rate = binding.rate.text.toString().filterDouble()

            when (0.0) {
                investedAmount -> {
                    showDialogError(getString(R.string.invalid_invested_amount))
                    return@setOnClickListener
                }
                rate -> {
                    showDialogError(getString(R.string.invalid_rate_amount))
                    return@setOnClickListener
                }
            }

            if (maturityDate == null) {
                showDialogError(getString(R.string.invalid_date))
                return@setOnClickListener
            }

            viewModel.setParameters(
                ParametersRequest(
                    investedAmount = investedAmount,
                    maturityDate = maturityDate.format(DateTimeFormat.YYYY_MM_DD),
                    rate = rate,
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
            showDialogError(getString(R.string.loading_error))
        }

        viewModel.loadingLiveData.observe(viewLifecycleOwner) {
            binding.progress.isVisible = it
            binding.simulate.isEnabled = !it
        }

    }

    private fun showDialogError(message: String) {
        MaterialAlertDialogBuilder(requireContext())
            .setMessage(message)
            .setPositiveButton(android.R.string.ok, null)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}