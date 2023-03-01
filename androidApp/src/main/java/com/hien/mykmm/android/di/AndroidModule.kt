package com.hien.mykmm.android.di

import com.hien.mykmm.android.ui.GreetPresenter
import org.koin.dsl.module

val androidModule = module {
    single {
        GreetPresenter(greeting = get())
    }
}