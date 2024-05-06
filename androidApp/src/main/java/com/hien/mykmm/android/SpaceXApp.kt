package com.hien.mykmm.android

import android.app.Application
import com.hien.mykmm.di.initKoin
import com.hien.mykmm.viewmodels.DetailViewModel
import com.hien.mykmm.viewmodels.RocketViewModel
import org.koin.dsl.module

class SpaceXApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(
            listOf(
                module {
                    factory { RocketViewModel(get()) }
                    factory { DetailViewModel(get()) }
                }
            )
        )
    }
}