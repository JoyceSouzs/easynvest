package com.example.easynvesttest.util

import com.example.easynvesttest.presentation.model.SimulatorCalculatorData

sealed class SimulatorCalculatorResult<out T> {
   data class Success<out T>(val simulation: SimulatorCalculatorData) : SimulatorCalculatorResult<T>()
   data class ApiError(val statusCode: Int, val msg: String) : SimulatorCalculatorResult<Nothing>()
}
