package com.example.easynvesttest.domain.request

class InvestmentRequest(
    val investedAmount: Double,
    val index: String = "CDI",
    val rate: Double,
    val isTaxFree: Boolean = false,
    val maturityDate: String
)