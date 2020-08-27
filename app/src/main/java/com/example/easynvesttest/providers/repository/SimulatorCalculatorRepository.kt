package com.example.easynvesttest.providers.repository

import com.example.easynvesttest.domain.request.ParametersRequest
import com.example.easynvesttest.presentation.model.SimulatorCalculatorData

interface SimulatorCalculatorRepository {
    suspend fun getInvestmentValues(
        parametersRequest: ParametersRequest
    ) : SimulatorCalculatorData
}