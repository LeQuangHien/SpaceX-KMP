package com.hien.mykmm.di

import co.touchlab.skie.configuration.annotations.DefaultArgumentInterop
import com.hien.mykmm.data.InMemorySpaceXStorage
import com.hien.mykmm.data.SpaceXRepository
import com.hien.mykmm.data.SpaceXStorage
import com.hien.mykmm.network.DefaultSpaceXApi
import com.hien.mykmm.network.SpaceXApi
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

val dataModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        useAlternativeNames = false
                    },
                )
            }
        }
    }

    single<SpaceXApi> {
        DefaultSpaceXApi(get())
    }
    single<SpaceXStorage> { InMemorySpaceXStorage() }
    single {
        SpaceXRepository(get(), get()).apply {
            initialize()
        }
    }
}


@DefaultArgumentInterop.Enabled
fun initKoin(modules: List<Module> = emptyList()) {
    startKoin {
        modules(
            dataModule,
            *modules.toTypedArray(),
        )
    }
}