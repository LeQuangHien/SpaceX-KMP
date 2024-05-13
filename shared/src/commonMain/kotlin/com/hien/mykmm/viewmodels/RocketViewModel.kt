package com.hien.mykmm.viewmodels

import com.hien.mykmm.data.RocketLaunch
import com.hien.mykmm.data.SpaceXRepository
import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.stateIn
import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow

class RocketViewModel(spaceXRepository: SpaceXRepository) : KMMViewModel() {
    @NativeCoroutines
    val objects: StateFlow<List<RocketLaunch>> =
        spaceXRepository.getObjects()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
}
