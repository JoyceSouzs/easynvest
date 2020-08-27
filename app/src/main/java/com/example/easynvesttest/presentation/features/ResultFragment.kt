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
        setupView()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    private fun setupView() {
        button_simulate_again.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    private fun setupObservers() {
        viewModel.facilitatorInvestment().observeForever {
            text_result_simulate.text = it.grossAmount.toString()
            text_total_yield.text = it.grossAmountProfit.toString()
            text_total_applied_value.text = it.grossAmount.toString()
            text_yield_value.text = it.grossAmountProfit.toString()

            text_ir_applied.text = "R$ ${it.taxesAmount}(${it.taxesRate})"

            text_net_applied_value.text = it.netAmount.toString()
            text_yield_annual.text = it.annualGrossRateProfit.toString()
            text_yield_monthly.text = it.monthlyGrossRateProfit.toString()
            text_yield_period.text = it.rateProfit.toString()


            it.investmentParameter.let { parameter ->
                text_initially_applied_value.text = parameter?.investedAmount.toString()
                text_redemption_date.text = parameter?.maturityDate.toString()
                text_running_days.text = parameter?.maturityTotalDays.toString()
                text_rate_applied_cdi.text = parameter?.rate.toString()
            }

        }
    }
}