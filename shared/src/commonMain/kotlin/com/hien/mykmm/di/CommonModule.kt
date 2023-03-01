package com.hien.mykmm.di

import com.hien.mykmm.Greeting
import com.hien.mykmm.data.SpaceXRepository
import com.hien.mykmm.network.SpaceXApi
import org.koin.dsl.module

val commonModule = module {
    single {
        Greeting()
    }
    single {
        SpaceXApi()
    }
    single {
        SpaceXRepository(
            spaceXApi = get()
        )
    }
}