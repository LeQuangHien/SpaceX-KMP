package data

import com.hien.mykmm.data.Links
import com.hien.mykmm.data.RocketLaunch
import com.hien.mykmm.data.SpaceXRepository
import com.hien.mykmm.network.SpaceXApi
import io.mockative.Mock
import io.mockative.classOf
import io.mockative.given
import io.mockative.mock
import io.mockative.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
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

@ExperimentalCoroutinesApi
class SpaceXRepositoryMockativeTest {

    @Mock
    private val mockSpaceXApi = mock(classOf<SpaceXApi>())

    @BeforeTest
    fun setupMocks() {
    }

    @Test
    fun `getAllLaunches calls the api call`() = runTest {
        given(mockSpaceXApi).coroutine { getAllLaunches() }
            .then { rocketLaunchList }

        val repository = SpaceXRepository(mockSpaceXApi)
        repository.getAllLaunches()

        verify(mockSpaceXApi).coroutine { getAllLaunches() }
            .wasInvoked()
    }

}