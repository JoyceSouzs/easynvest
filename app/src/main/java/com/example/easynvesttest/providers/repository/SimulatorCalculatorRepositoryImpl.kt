package com.example.easynvesttest.providers.repository

import com.example.easynvesttest.domain.request.InvestmentRequest
import com.example.easynvesttest.presentation.model.Investment
import com.example.easynvesttest.providers.dataSource.SimulatorCalculatorDataSource

class SimulatorCalculatorRepositoryImpl(
    private val dataSource: SimulatorCalculatorDataSource
) : SimulatorCalculatorRepository {
    override suspend fun getInvestmentValues(
//        investedAmount: Double,
//        index: String,
//        rate: Double,
//        isTaxFree: Boolean,
//        maturityDate: String
    investmentRequest: InvestmentRequest
    ): Investment {
        val response = dataSource.getInvestmentValues(investmentRequest)
        return response.body()!!.toInvestment()
    }
}