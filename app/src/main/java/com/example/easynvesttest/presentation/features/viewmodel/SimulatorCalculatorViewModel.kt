package com.example.easynvesttest.presentation.features.viewmodel

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.easynvesttest.domain.request.ParametersRequest
import com.example.easynvesttest.presentation.model.SimulatorCalculatorData
import com.example.easynvesttest.providers.repository.SimulatorCalculatorRepository
import com.example.easynvesttest.util.Event
import kotlinx.coroutines.launch

class SimulatorCalculatorViewModel(
    private val repository: SimulatorCalculatorRepository
) : ViewModel() {

    private val _simulatorCalculatorData: MutableLiveData<SimulatorCalculatorData> = MutableLiveData()
    val simulatorCalculatorData: LiveData<SimulatorCalculatorData> = _simulatorCalculatorData

    private val _navigateToResultAction = MutableLiveData<Event<Unit>>()
    val navigateToResultAction: LiveData<Event<Unit>> = _navigateToResultAction

    private val _errorLiveData = MutableLiveData<Event<Unit>>()
    val errorLiveData: LiveData<Event<Unit>> = _errorLiveData

    private val _loadingLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val loadingLiveData: LiveData<Boolean> = _loadingLiveData

    @VisibleForTesting
    val parameters = ParametersRequest()

    fun setParameters(parametersRequest : ParametersRequest) {
        parameters.investedAmount = parametersRequest.investedAmount
        parameters.rate = parametersRequest.rate
        parameters.maturityDate = parametersRequest.maturityDate
    }

    fun calculatorInvestment() {
        viewModelScope.launch {
            try {
                _loadingLiveData.postValue(true)
                val response = repository.getInvestmentValues(parameters)
                _simulatorCalculatorData.postValue(response)
                _navigateToResultAction.postValue(Event(Unit))
            } catch (throwable: Throwable) {
                throwable.printStackTrace()
                _errorLiveData.postValue(Event(Unit))
            } finally {
                _loadingLiveData.postValue(false)
            }
        }
    }
}

