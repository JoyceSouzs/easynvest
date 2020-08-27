package com.example.easynvesttest.providers.repository

import com.example.easynvesttest.domain.request.ParametersRequest
import com.example.easynvesttest.presentation.model.SimulatorCalculatorData
import com.example.easynvesttest.providers.dataSource.SimulatorCalculatorDataSource

class SimulatorCalculatorRepositoryImpl(
    private val dataSource: SimulatorCalculatorDataSource
) : SimulatorCalculatorRepository {
    override suspend fun getInvestmentValues(
        parametersRequest: ParametersRequest
    ): SimulatorCalculatorData {
        val response = dataSource.getInvestmentValues(parametersRequest)
        return response.body()!!.toInvestment()
    }
}