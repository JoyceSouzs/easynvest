package com.example.easynvesttest.providers.di

import com.example.easynvesttest.providers.dataSource.SimulatorCalculatorDataSource
import com.example.easynvesttest.providers.dataSource.SimulatorCalculatorDataSourceImpl
import com.example.easynvesttest.providers.repository.SimulatorCalculatorRepository
import com.example.easynvesttest.providers.repository.SimulatorCalculatorRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<SimulatorCalculatorDataSource> { SimulatorCalculatorDataSourceImpl(get()) }

    single<SimulatorCalculatorRepository> { SimulatorCalculatorRepositoryImpl(get()) }

//    single { SimulatorCalculatorDataSourceImpl(get()) }
//    single { SimulatorCalculatorRepositoryImpl(get()) }
}