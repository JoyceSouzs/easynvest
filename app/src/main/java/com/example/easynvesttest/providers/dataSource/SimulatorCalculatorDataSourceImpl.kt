package com.example.easynvesttest.providers.dataSource

import com.example.easynvesttest.domain.request.ParametersRequest
import com.example.easynvesttest.domain.response.SimulatorCalculatorResponse
import com.example.easynvesttest.providers.api.SimulatorCalcApi
import retrofit2.Response

class SimulatorCalculatorDataSourceImpl(
    private val api: SimulatorCalcApi
) : SimulatorCalculatorDataSource {
    override suspend fun getInvestmentValues(
        parametersRequest: ParametersRequest
    ): Response<SimulatorCalculatorResponse> {
        return api.calculatorInvestment(
            parametersRequest.investedAmount,
            parametersRequest.index,
            parametersRequest.rate,
            parametersRequest.isTaxFree,
            parametersRequest.maturityDate
        )
    }
}