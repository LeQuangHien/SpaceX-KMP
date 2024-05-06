package com.hien.mykmm.data

import com.hien.mykmm.network.SpaceXApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class SpaceXRepository(
    private val spaceXApi: SpaceXApi,
    private val spaceXStorage: SpaceXStorage
) {
    private val scope = CoroutineScope(SupervisorJob())

    fun initialize() {
            scope.launch {
                refresh()
            }
        }


    private suspend fun refresh() {
        spaceXStorage.saveObjects(spaceXApi.getAllLaunches())
    }

    fun getObjects(): Flow<List<RocketLaunch>> = spaceXStorage.getObjects()

    fun getObjectById(objectId: Int): Flow<RocketLaunch?> = spaceXStorage.getObjectById(objectId)
}