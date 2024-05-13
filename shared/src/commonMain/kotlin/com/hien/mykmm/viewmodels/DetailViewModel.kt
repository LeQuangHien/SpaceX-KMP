package com.hien.mykmm.viewmodels

import com.hien.mykmm.data.RocketLaunch
import com.hien.mykmm.data.SpaceXRepository
import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.stateIn
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf

class DetailViewModel(private val spaceXRepository: SpaceXRepository) : KMMViewModel() {
    private val objectId = MutableStateFlow<Int?>(null)

    @OptIn(ExperimentalCoroutinesApi::class)
    @NativeCoroutinesState
    val rocketLaunch: StateFlow<RocketLaunch?> = objectId
        .flatMapLatest {
            val id = it ?: return@flatMapLatest flowOf(null)
            spaceXRepository.getObjectById(id)
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    fun setId(objectId: Int) {
        this.objectId.value = objectId
    }
}
