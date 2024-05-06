package com.hien.mykmm

import com.hien.mykmm.data.SpaceXRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class KoinDependencies : KoinComponent {
    val spaceXRepository: SpaceXRepository by inject()
}
