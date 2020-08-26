package com.example.easynvesttest.providers.repository

import com.example.easynvesttest.domain.request.InvestmentRequest
import com.example.easynvesttest.presentation.model.Investment

interface SimulatorCalculatorRepository {
    suspend fun getInvestmentValues(
//        investedAmount: Double,
//        index: String,
//        rate: Double,
//        isTaxFree: Boolean,
//        maturityDate: String
    investmentRequest: InvestmentRequest
    ) : Investment
}