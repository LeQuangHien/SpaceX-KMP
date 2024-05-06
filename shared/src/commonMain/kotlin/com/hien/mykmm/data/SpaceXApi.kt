package com.hien.mykmm.network

import com.hien.mykmm.data.RocketLaunch
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

interface SpaceXApi {
    suspend fun getAllLaunches(): List<RocketLaunch>
}

class DefaultSpaceXApi(private val client: HttpClient) : SpaceXApi {
    override suspend fun getAllLaunches(): List<RocketLaunch> {
        return client.get("https://api.spacexdata.com/v5/launches").body()
    }
}
