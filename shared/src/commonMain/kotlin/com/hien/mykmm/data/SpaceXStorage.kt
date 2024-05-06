package com.hien.mykmm.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map

interface SpaceXStorage {
    suspend fun saveObjects(newObjects: List<RocketLaunch>)

    fun getObjectById(flightNumber: Int): Flow<RocketLaunch?>

    fun getObjects(): Flow<List<RocketLaunch>>
}

class InMemorySpaceXStorage : SpaceXStorage {
    private val storedObjects = MutableStateFlow(emptyList<RocketLaunch>())

    override suspend fun saveObjects(newObjects: List<RocketLaunch>) {
        storedObjects.value = newObjects
    }

    override fun getObjectById(flightNumber: Int): Flow<RocketLaunch?> {
        return storedObjects.map { objects ->
            objects.find { it.flightNumber == flightNumber }
        }
    }

    override fun getObjects(): Flow<List<RocketLaunch>> = storedObjects
}