package com.example.easynvesttest.presentation.features.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.easynvesttest.domain.request.ParametersRequest
import com.example.easynvesttest.presentation.BaseViewModel
import com.example.easynvesttest.presentation.model.SimulatorCalculatorData
import com.example.easynvesttest.providers.repository.SimulatorCalculatorRepository
import kotlinx.coroutines.launch

class SimulatorCalculatorViewModel(
    private val repository: SimulatorCalculatorRepository
) : BaseViewModel() {

    private val simulatorCalculatorData: MutableLiveData<SimulatorCalculatorData> = MutableLiveData()
    private var parameters = ParametersRequest()

    fun facilitatorInvestment(): LiveData<SimulatorCalculatorData> {
        if (simulatorCalculatorData.value == null) {
            calculatorInvestment()
        }
        return simulatorCalculatorData
    }

    fun setParameters(parametersRequest : ParametersRequest) {
        parameters.investedAmount = parametersRequest.investedAmount
        parameters.rate = parametersRequest.rate
        parameters.maturityDate = parametersRequest.maturityDate
    }

    private fun calculatorInvestment() {
        viewModelScope.launch {
            try {
                loadingLiveData.postValue(true)
                val response = repository.getInvestmentValues(parameters)
                simulatorCalculatorData.postValue(response)
            } catch (throwable: Throwable) {
                throwable.printStackTrace()
            } finally {
                loadingLiveData.postValue(false)
            }
        }
    }
}

