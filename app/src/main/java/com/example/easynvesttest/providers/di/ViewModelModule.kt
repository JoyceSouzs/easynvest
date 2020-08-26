package com.example.easynvesttest.providers.di

import com.example.easynvesttest.presentation.features.viewmodel.SimulatorCalculatorViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        SimulatorCalculatorViewModel(get()) }
}
