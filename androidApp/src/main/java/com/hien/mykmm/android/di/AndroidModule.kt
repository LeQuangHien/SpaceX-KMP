package com.hien.mykmm.android.di

import com.hien.mykmm.android.ui.GreetPresenter
import com.hien.mykmm.android.ui.RocketViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidModule = module {
    single {
        GreetPresenter(greeting = get())
    }
    viewModel {
        RocketViewModel(spaceXRepository = get())
    }
}