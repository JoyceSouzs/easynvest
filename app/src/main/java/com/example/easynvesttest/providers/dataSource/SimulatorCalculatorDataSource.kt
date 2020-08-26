package com.example.easynvesttest.providers.dataSource

import com.example.easynvesttest.domain.request.InvestmentRequest
import com.example.easynvesttest.domain.response.InvestmentResponse
import retrofit2.Response

interface SimulatorCalculatorDataSource {
    suspend fun getInvestmentValues(
//        investedAmount: Double,
//        index: String,
//        rate: Double,
//        isTaxFree: Boolean,
//        maturityDate: String
    investmentRequest: InvestmentRequest
    ) : Response<InvestmentResponse>
}