package com.hien.mykmm.data

import com.hien.mykmm.network.SpaceXApi

class SpaceXRepository(
    private val spaceXApi: SpaceXApi
) {
    suspend fun getAllLaunches(): List<RocketLaunch> = spaceXApi.getAllLaunches()
}