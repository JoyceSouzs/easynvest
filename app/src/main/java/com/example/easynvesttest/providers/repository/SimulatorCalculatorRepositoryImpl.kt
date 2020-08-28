package com.example.easynvesttest.providers.repository

import com.example.easynvesttest.domain.request.ParametersRequest
import com.example.easynvesttest.presentation.model.InvestmentParameter
import com.example.easynvesttest.presentation.model.SimulatorCalculatorData
import com.example.easynvesttest.providers.api.EasyApiException
import com.example.easynvesttest.providers.dataSource.SimulatorCalculatorDataSource
import org.threeten.bp.LocalDateTime

class SimulatorCalculatorRepositoryImpl(
    private val dataSource: SimulatorCalculatorDataSource
) : SimulatorCalculatorRepository {
    override suspend fun getInvestmentValues(
        parametersRequest: ParametersRequest
    ): SimulatorCalculatorData {

        val SIMULATION = SimulatorCalculatorData(
        investmentParameter = InvestmentParameter(
            investedAmount = 32323.0,
            yearlyInterestRate = 9.5512,
            maturityTotalDays = 1981,
            maturityBusinessDays = 1409,
            maturityDate = LocalDateTime.of(2023, 3, 3, 0, 0),
            rate = 123.0,
            isTaxFree = false,
        ),
        grossAmount = 60528.20,
        taxesAmount = 4230.78,
        netAmount = 56297.42,
        grossAmountProfit = 28205.20,
        netAmountProfit = 23974.42,
        annualGrossRateProfit = 87.26,
        monthlyGrossRateProfit = 0.76,
        dailyGrossRateProfit = 0.000445330025305748,
        taxesRate = 15.0,
        rateProfit = 9.5512,
        annualNetRateProfit = 74.17
        )

//        val response = dataSource.getInvestmentValues(parametersRequest)
//
//        if (response.isSuccessful) {
//            return response.body()!!.toInvestment()
//        } else {
//            throw EasyApiException(response.code())
//        }


        return SIMULATION
    }
}