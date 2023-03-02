package data

import com.hien.mykmm.data.Links
import com.hien.mykmm.data.RocketLaunch
import com.hien.mykmm.data.SpaceXRepository
import com.hien.mykmm.network.SpaceXApi
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test


private val rocketLaunchList = listOf(
    RocketLaunch(
        flightNumber = 1, missionName = "Falcon1", launchDateUTC = "2006-03-24T22:30:00.000Z",
        launchSuccess = true, details = null, links = Links(null, null)
    ), RocketLaunch(
        flightNumber = 2, missionName = "Falcon1", launchDateUTC = "2006-03-24T22:30:00.000Z",
        launchSuccess = true, details = null, links = Links(null, null)
    )
)

class SpaceXRepositoryTest {
    private lateinit var spaceXApi: SpaceXApi

    @BeforeTest
    fun setupMocks() {
        spaceXApi = mockk {
            coEvery { getAllLaunches() } returns rocketLaunchList
        }
    }

    @Test
    fun `getAllLaunches calls the api call`() = runTest {
        val repository = SpaceXRepository(spaceXApi)

        repository.getAllLaunches()

        coVerify { spaceXApi.getAllLaunches() }
    }

}