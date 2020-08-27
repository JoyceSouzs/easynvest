package com.example.easynvesttest.domain.response

import com.example.easynvesttest.presentation.model.SimulatorCalculatorData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class SimulatorCalculatorResponse(
    @Json(name = "investmentParameter") val investmentParameter: InvestmentParameterResponse? = null,
    @Json(name = "grossAmount") val grossAmount: Double? = null,
    @Json(name = "taxesAmount") val taxesAmount: Double? = null,
    @Json(name = "netAmount") val netAmount: Double? = null,
    @Json(name = "grossAmountProfit") val grossAmountProfit: Double? = null,
    @Json(name = "netAmountProfit") val netAmountProfit: Double? = null,
    @Json(name = "annualGrossRateProfit") val annualGrossRateProfit: Double? = null,
    @Json(name = "monthlyGrossRateProfit") val monthlyGrossRateProfit: Double? = null,
    @Json(name = "dailyGrossRateProfit") val dailyGrossRateProfit: Double? = null,
    @Json(name = "taxesRate") val taxesRate: Double? = null,
    @Json(name = "rateProfit") val rateProfit: Double? = null,
    @Json(name = "annualNetRateProfit") val annualNetRateProfit: Double? = null
) {
    fun toInvestment() : SimulatorCalculatorData {
        return SimulatorCalculatorData(
            investmentParameter = investmentParameter!!.toInvestmentParameter(),
            grossAmount = grossAmount ?: 0.0,
            taxesAmount = taxesAmount ?: 0.0,
            taxesRate = taxesRate ?: 0.0,
            netAmount = netAmount ?: 0.0,
            grossAmountProfit = grossAmountProfit ?: 0.0,
            netAmountProfit = netAmountProfit ?: 0.0,
            annualGrossRateProfit = annualGrossRateProfit ?: 0.0,
            monthlyGrossRateProfit = monthlyGrossRateProfit ?: 0.0,
            dailyGrossRateProfit = dailyGrossRateProfit ?: 0.0,
            rateProfit = rateProfit ?: 0.0,
            annualNetRateProfit = annualNetRateProfit ?: 0.0
        )
    }
}



