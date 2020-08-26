package com.example.easynvesttest.providers.di

import org.koin.dsl.module

val appModule = module {}

val appModules = listOf(
    appModule,
    androidModule,
    retrofitModule,
    repositoryModule,
    viewModelModule
)