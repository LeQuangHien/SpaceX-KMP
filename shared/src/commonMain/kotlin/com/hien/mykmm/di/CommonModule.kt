package com.hien.mykmm.di

import com.hien.mykmm.Greeting
import org.koin.dsl.module

val commonModule = module {
    single {
        Greeting()
    }
}