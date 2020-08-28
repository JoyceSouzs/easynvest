package com.example.easynvesttest.data

import com.example.easynvesttest.presentation.model.InvestmentParameter
import com.example.easynvesttest.presentation.model.SimulatorCalculatorData
import org.threeten.bp.LocalDateTime

object TestSimulatorCalculatorData {

    private val investmentParameter = InvestmentParameter(
        investedAmount = 32323.0,
        yearlyInterestRate = 9.5512,
        maturityTotalDays = 1981,
        maturityBusinessDays = 1409,
        maturityDate = LocalDateTime.of(2023, 3, 3, 0, 0),
        rate = 123.0,
        isTaxFree = false,
    )

    val simulator_data = SimulatorCalculatorData(
        investmentParameter = investmentParameter,
        grossAmount = 60528.20,
        taxesAmount = 4230.78,
        netAmount = 56297.42,
        grossAmountProfit = 28205.20,
        netAmountProfit = 23974.42,
        annualGrossRateProfit = 87.26,
        monthlyGrossRateProfit = 0.76,
        dailyGrossRateProfit = 0.000445330025305748,
        taxesRate = 15.0,
        rateProfit = 9.5512,
        annualNetRateProfit = 74.17
    )
}