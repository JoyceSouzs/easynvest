package com.example.easynvesttest.presentation.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.easynvesttest.R
import com.example.easynvesttest.databinding.FragmentFormBinding
import com.example.easynvesttest.databinding.FragmentResultBinding
import com.example.easynvesttest.presentation.features.viewmodel.SimulatorCalculatorViewModel
import com.example.easynvesttest.util.DateTimeFormat
import com.example.easynvesttest.util.Format
import kotlinx.android.synthetic.main.fragment_result.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ResultFragment : Fragment() {
   private val viewModel: SimulatorCalculatorViewModel by sharedViewModel()

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupView()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun setupView() {
        binding.simulateAgain.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    private fun setupObservers() {
        viewModel.simulatorCalculatorData.observe(viewLifecycleOwner) {
            binding.grossAmount.text = Format.CURRENCY_REAL.format(it.grossAmount)
            binding.grossAmountProfit.text = Format.CURRENCY_REAL.format(it.grossAmountProfit)
            binding.grossAmountInvest.text = Format.CURRENCY_REAL.format(it.grossAmount)
            binding.grossAmountProfitValue.text = Format.CURRENCY_REAL.format(it.grossAmountProfit)
            Format.CURRENCY_REAL.format(it.grossAmountProfit)

            binding.taxesAmount.text = getString(
                R.string.text_label_taxes_amount,
                Format.CURRENCY_REAL.format(it.taxesAmount),
                Format.DECIMAL_PERCENT_PT_BR.format(it.taxesRate)
            )

            binding.netAmount.text = Format.CURRENCY_REAL.format(
                it.netAmount
            )
            binding.annualGrossRateProfit.text = Format.DECIMAL_PERCENT_PT_BR.format(
                it.annualGrossRateProfit
            )

            binding.monthlyGrossRateProfit.text =  Format.DECIMAL_PERCENT_PT_BR.format(
                it.monthlyGrossRateProfit
            )
            binding.rateProfit.text =  Format.DECIMAL_PERCENT_PT_BR.format(
                it.rateProfit
            )

            it.investmentParameter.let { parameter ->
                binding.investedAmount.text = Format.CURRENCY_REAL.format(
                    parameter?.investedAmount
                )

                binding.maturityDate.text =  DateTimeFormat.DD_MM_YYYY.format(
                    parameter?.maturityDate
                )
                binding.maturityTotalDays.text = parameter?.maturityTotalDays.toString()
                binding.rate.text =  Format.NUMBER_PERCENT_PT_BR.format(
                    parameter?.rate
                )
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}