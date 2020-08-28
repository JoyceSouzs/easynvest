package com.example.easynvesttest.presentation.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.easynvesttest.R
import com.example.easynvesttest.presentation.features.viewmodel.SimulatorCalculatorViewModel
import com.example.easynvesttest.util.DateTimeFormat
import com.example.easynvesttest.util.Format
import kotlinx.android.synthetic.main.fragment_result.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ResultFragment : Fragment() {
   private val viewModel: SimulatorCalculatorViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupView()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    private fun setupView() {
        button_simulate_again.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    private fun setupObservers() {
        viewModel.simulatorCalculatorData.observe(viewLifecycleOwner) {
            text_result_simulate.text = Format.CURRENCY_REAL.format(it.grossAmount)
            text_total_yield.text = Format.CURRENCY_REAL.format(it.grossAmountProfit)
            text_total_applied_value.text = Format.CURRENCY_REAL.format(it.grossAmount)
            text_yield_value.text = Format.CURRENCY_REAL.format(it.grossAmountProfit)
            Format.CURRENCY_REAL.format(it.grossAmountProfit)

            text_ir_applied.text = getString(
                R.string.text_label_taxes_amount,
                Format.CURRENCY_REAL.format(it.taxesAmount),
                Format.DECIMAL_PERCENT_PT_BR.format(it.taxesRate)
            )

            text_net_applied_value.text = Format.CURRENCY_REAL.format(
                it.netAmount
            )
            text_yield_annual.text = Format.DECIMAL_PERCENT_PT_BR.format(
                it.annualGrossRateProfit
            )

            text_yield_monthly.text =  Format.DECIMAL_PERCENT_PT_BR.format(
                it.monthlyGrossRateProfit
            )
            text_yield_period.text =  Format.DECIMAL_PERCENT_PT_BR.format(
                it.rateProfit
            )

            it.investmentParameter.let { parameter ->
                text_initially_applied_value.text = Format.CURRENCY_REAL.format(
                    parameter?.investedAmount
                )

                text_redemption_date.text =  DateTimeFormat.DD_MM_YYYY.format(
                    parameter?.maturityDate
                )
                text_running_days.text = parameter?.maturityTotalDays.toString()
                text_rate_applied_cdi.text =  Format.NUMBER_PERCENT_PT_BR.format(
                    parameter?.rate
                )
            }

        }
    }
}