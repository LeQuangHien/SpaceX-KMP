package com.hien.mykmm.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hien.mykmm.MyApplicationTheme
import com.hien.mykmm.data.Links
import com.hien.mykmm.data.RocketLaunch
import com.hien.mykmm.viewmodels.RocketViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun RocketScreen(navigateToDetails: (objectId: Int) -> Unit) {
    val rocketViewModel: RocketViewModel = koinViewModel()
    val objects by rocketViewModel.objects.collectAsState()

    AnimatedContent(objects.isNotEmpty()) { objectsAvailable ->
        if (objectsAvailable) {
            RocketLaunchList(
                rockets = objects,
                onItemClick = navigateToDetails
            )
        } else {
            EmptyScreenContent(Modifier.fillMaxSize())
        }
    }

}

@Composable
fun RocketLaunchList(
    modifier: Modifier = Modifier,
    rockets: List<RocketLaunch>,
    onItemClick: (objectId: Int) -> Unit,
) {
    LazyColumn(modifier = modifier.padding(8.dp)) {
        items(rockets, key = { it.flightNumber }) { rocket ->
            RocketCardView(rocket = rocket, onItemClick = { onItemClick(rocket.flightNumber) })
        }
    }
}

@Composable
fun RocketCardView(
    rocket: RocketLaunch,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier
                .padding(8.dp)
                .clickable { onItemClick() }
        ) {
            Text(
                text = rocket.missionName,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Launch Year: ${rocket.launchYear}",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Gray,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = "Flight number: ${rocket.flightNumber}",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(top = 16.dp)
            )
            rocket.details?.let {
                Text(
                    text = "Details: ${rocket.details}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun RocketCardViewPreview() {
    MyApplicationTheme {
        RocketCardView(
            RocketLaunch(
                missionName = "FalconSat",
                launchDateUTC = "2006-03-24T22:30:00.000Z",
                details = "Successful first stage burn and transition to second stage, maximum altitude 289 km, Premature engine shutdown at T+7 min 30 s, Failed to reach orbit, Failed to recover first stage",
                flightNumber = 1,
                links = Links(
                    patch = null,
                    article = "https://www.space.com/3590-spacex-falcon-1-rocket-fails-reach-orbit.html"
                ),
                launchSuccess = null
            ),
            onItemClick = {}
        )
    }
}

@Preview
@Composable
fun RocketListPreview() {
    MyApplicationTheme {
        RocketLaunchList(
            rockets = listOf(
                RocketLaunch(
                    missionName = "FalconSat",
                    launchDateUTC = "2006-03-24T22:30:00.000Z",
                    details = "Successful first stage burn and transition to second stage, maximum altitude 289 km, Premature engine shutdown at T+7 min 30 s, Failed to reach orbit, Failed to recover first stage",
                    flightNumber = 1,
                    links = Links(
                        patch = null,
                        article = "https://www.space.com/3590-spacex-falcon-1-rocket-fails-reach-orbit.html"
                    ),
                    launchSuccess = null
                ),
                RocketLaunch(
                    missionName = "FalconSat",
                    launchDateUTC = "2006-03-24T22:30:00.000Z",
                    details = "Successful first stage burn and transition to second stage, maximum altitude 289 km, Premature engine shutdown at T+7 min 30 s, Failed to reach orbit, Failed to recover first stage",
                    flightNumber = 2,
                    links = Links(
                        patch = null,
                        article = "https://www.space.com/3590-spacex-falcon-1-rocket-fails-reach-orbit.html"
                    ),
                    launchSuccess = null
                ),
                RocketLaunch(
                    missionName = "FalconSat",
                    launchDateUTC = "2006-03-24T22:30:00.000Z",
                    details = "Successful first stage burn and transition to second stage, maximum altitude 289 km, Premature engine shutdown at T+7 min 30 s, Failed to reach orbit, Failed to recover first stage",
                    flightNumber = 3,
                    links = Links(
                        patch = null,
                        article = "https://www.space.com/3590-spacex-falcon-1-rocket-fails-reach-orbit.html"
                    ),
                    launchSuccess = null
                ),
            ),
            onItemClick = {}
        )
    }
}