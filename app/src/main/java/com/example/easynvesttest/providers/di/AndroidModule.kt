package com.example.easynvesttest.providers.di

import com.squareup.moshi.Moshi
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

var moshi = StringQualifier("moshi")

val androidModule = module {
    single(moshi) {
        Moshi.Builder()
            .build()
    }
}