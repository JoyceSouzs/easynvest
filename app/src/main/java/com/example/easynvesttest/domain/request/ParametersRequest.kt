package com.example.easynvesttest.domain.request

data class ParametersRequest(
    var investedAmount: Double = 0.0,
    val index: String = "CDI",
    var rate: Double = 0.0,
    val isTaxFree: Boolean = false,
    var maturityDate: String = ""
)