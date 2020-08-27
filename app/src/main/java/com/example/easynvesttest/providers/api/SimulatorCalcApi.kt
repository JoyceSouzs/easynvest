package com.example.easynvesttest.providers.api

import com.example.easynvesttest.domain.response.SimulatorCalculatorResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SimulatorCalcApi {
    @GET("calculator/simulate")
   suspend fun calculatorInvestment(
        @Query("investedAmount") investedAmount: Double,
        @Query("index") index: String,
        @Query("rate") rate: Double,
        @Query("isTaxFree") isTaxFree: Boolean,
        @Query("maturityDate") maturityDate: String
    ): Response<SimulatorCalculatorResponse>
}
