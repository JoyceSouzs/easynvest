package com.example.easynvesttest.providers.dataSource

import com.example.easynvesttest.domain.request.InvestmentRequest
import com.example.easynvesttest.domain.response.InvestmentResponse
import com.example.easynvesttest.providers.api.SimulatorCalcApi
import retrofit2.Response

class SimulatorCalculatorDataSourceImpl(
    private val api: SimulatorCalcApi
) : SimulatorCalculatorDataSource {
    override suspend fun getInvestmentValues(
//        investedAmount: Double,
//        index: String,
//        rate: Double,
//        isTaxFree: Boolean,
//        maturityDate: String
    investmentRequest: InvestmentRequest
    ): Response<InvestmentResponse> {
        return api.calculatorInvestment(
            investmentRequest.investedAmount,
            investmentRequest.index,
            investmentRequest.rate,
            investmentRequest.isTaxFree,
            investmentRequest.maturityDate
        )
    }
}