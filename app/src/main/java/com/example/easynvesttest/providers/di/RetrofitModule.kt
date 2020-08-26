package com.example.easynvesttest.providers.di

import com.example.easynvesttest.providers.api.SimulatorCalcApi
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

var retrofit = StringQualifier("retrofit")

val retrofitModule = module {
    single(retrofit) {
        Retrofit.Builder()
            .baseUrl("https://api-simulator-calc.easynvest.com.br/")
            .addConverterFactory(MoshiConverterFactory.create(get(moshi)))
            .build()
    }

    single {
        val retrofit: Retrofit = get(retrofit)
        retrofit.create(SimulatorCalcApi::class.java)
    }
}