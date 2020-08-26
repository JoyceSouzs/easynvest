package com.example.easynvesttest.presentation.model

import org.threeten.bp.LocalDateTime


class Investment(
    val investmentParameter: InvestmentParameter? = null,
    val grossAmount: Double = 0.0,
    val taxesAmount: Double = 0.0,
    val netAmount: Double = 0.0,
    val grossAmountProfit: Double = 0.0,
    val netAmountProfit: Double = 0.0,
    val annualGrossRateProfit: Double = 0.0,
    val monthlyGrossRateProfit: Double = 0.0,
    val dailyGrossRateProfit: Double = 0.0,
    val taxesRate: Double = 0.0,
    val rateProfit: Double = 0.0,
    val annualNetRateProfit: Double = 0.0
)

class InvestmentParameter(
    val investedAmount: Double = 0.0,
    val yearlyInterestRate: Double = 0.0,
    val maturityTotalDays: Int = 0,
    val maturityBusinessDays: Int = 0,
    val maturityDate: LocalDateTime,
    val rate: Double = 0.0,
    val isTaxFree: Boolean = false,
)