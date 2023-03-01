package com.hien.mykmm

import com.hien.mykmm.data.RocketLaunch
import com.hien.mykmm.data.SpaceXRepository
import com.hien.mykmm.di.appModule
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

class GreetingHelper : KoinComponent {
    private val greeting: Greeting by inject()
    fun greet(): String = greeting.greet()
}

class SpaceXRepositoryHelper : KoinComponent {
    private val spaceXRepository: SpaceXRepository by inject()
    suspend fun getAllLaunches(): List<RocketLaunch> = spaceXRepository.getAllLaunches()
}

fun initKoin() {
    startKoin {
        modules(appModule())
    }
}
