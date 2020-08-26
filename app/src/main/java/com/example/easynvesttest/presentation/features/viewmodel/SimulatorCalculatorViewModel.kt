package com.example.easynvesttest.presentation.features.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.easynvesttest.domain.request.InvestmentRequest
import com.example.easynvesttest.presentation.BaseViewModel
import com.example.easynvesttest.presentation.model.Investment
import com.example.easynvesttest.providers.repository.SimulatorCalculatorRepository
import kotlinx.coroutines.launch

class SimulatorCalculatorViewModel(
    private val repository: SimulatorCalculatorRepository
) : BaseViewModel() {
    var investedAmount: Double = 32323.0
    var index: String = "CDI"
    var rate: Double = 123.0
    var isTaxFree: Boolean = false
    var maturityDate: String = "2023-03-03"

    private val investment: MutableLiveData<Investment> = MutableLiveData()

    fun facilitatorInvestment(): LiveData<Investment> {
        if (investment.value == null) {
            calculatorInvestment()
        }
        return investment
    }

    private fun calculatorInvestment() {
        val investmentRequest = InvestmentRequest(
            investedAmount, index, rate, isTaxFree, maturityDate
        )
        viewModelScope.launch {
            try {
                loadingLiveData.postValue(true)
                val response = repository.getInvestmentValues(investmentRequest)
                investment.postValue(response)
            } catch (throwable: Throwable) {
                throwable.printStackTrace()
            } finally {
                loadingLiveData.postValue(false)
            }
        }
    }
}

