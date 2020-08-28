package com.example.easynvesttest.providers.repository

import com.example.easynvesttest.domain.request.ParametersRequest
import com.example.easynvesttest.presentation.model.InvestmentParameter
import com.example.easynvesttest.presentation.model.SimulatorCalculatorData
import com.example.easynvesttest.providers.api.SimulatorCalcApiException
import com.example.easynvesttest.providers.dataSource.SimulatorCalculatorDataSource
import org.threeten.bp.LocalDateTime

class SimulatorCalculatorRepositoryImpl(
    private val dataSource: SimulatorCalculatorDataSource
) : SimulatorCalculatorRepository {
    override suspend fun getInvestmentValues(
        parametersRequest: ParametersRequest
    ): SimulatorCalculatorData {

        val response = dataSource.getInvestmentValues(parametersRequest)
        if (response.isSuccessful) {
            return response.body()!!.toInvestment()
        } else {
            throw SimulatorCalcApiException(response.code())
        }
    }
}