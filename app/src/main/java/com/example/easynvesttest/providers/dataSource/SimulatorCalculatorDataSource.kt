package com.example.easynvesttest.providers.dataSource

import com.example.easynvesttest.domain.request.ParametersRequest
import com.example.easynvesttest.domain.response.SimulatorCalculatorResponse
import retrofit2.Response

interface SimulatorCalculatorDataSource {
    suspend fun getInvestmentValues(
        parametersRequest: ParametersRequest
    ) : Response<SimulatorCalculatorResponse>
}