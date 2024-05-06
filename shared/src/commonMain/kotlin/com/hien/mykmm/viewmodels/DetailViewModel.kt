package com.hien.mykmm.viewmodels

import com.hien.mykmm.data.RocketLaunch
import com.hien.mykmm.data.SpaceXRepository
import com.rickclephas.kmm.viewmodel.KMMViewModel
import kotlinx.coroutines.flow.Flow

class DetailViewModel(private val spaceXRepository: SpaceXRepository) : KMMViewModel() {
    fun getObject(objectId: Int): Flow<RocketLaunch?> =
        spaceXRepository.getObjectById(objectId)
}
