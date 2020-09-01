package com.example.easynvesttest.providers.repository

import com.example.easynvesttest.domain.request.ParametersRequest
import com.example.easynvesttest.presentation.model.InvestmentParameter
import com.example.easynvesttest.presentation.model.SimulatorCalculatorData
import com.example.easynvesttest.providers.dataSource.SimulatorCalculatorDataSource
import com.example.easynvesttest.util.SimulatorCalculatorResult
import org.threeten.bp.LocalDateTime

class SimulatorCalculatorRepositoryImpl(
    private val dataSource: SimulatorCalculatorDataSource
) : SimulatorCalculatorRepository {
    override suspend fun getInvestmentValues(
        parametersRequest: ParametersRequest
    ): SimulatorCalculatorResult<SimulatorCalculatorData> {

        return try {
            val response = dataSource.getInvestmentValues(parametersRequest)
            if (response.isSuccessful) {
                val data = response.body()!!.toInvestment()
                SimulatorCalculatorResult.Success(data)
            } else {
                SimulatorCalculatorResult.ApiError(response.code(), response.message())
            }
        } catch (throwable: Throwable) {
            SimulatorCalculatorResult.ApiError(0, throwable.message.toString())
        }
    }
}