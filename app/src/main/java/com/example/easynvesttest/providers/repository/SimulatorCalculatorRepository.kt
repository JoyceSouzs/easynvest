package com.example.easynvesttest.providers.repository

import com.example.easynvesttest.domain.request.ParametersRequest
import com.example.easynvesttest.presentation.model.SimulatorCalculatorData
import com.example.easynvesttest.util.SimulatorCalculatorResult

interface SimulatorCalculatorRepository {
    suspend fun getInvestmentValues(
        parametersRequest: ParametersRequest
    ) : SimulatorCalculatorResult<SimulatorCalculatorData>
}