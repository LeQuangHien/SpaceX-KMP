package com.hien.mykmm.android.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hien.mykmm.android.MyApplicationTheme
import org.koin.androidx.compose.getViewModel

@Composable
internal fun RocketScreen(
    rocketViewModel: RocketViewModel = getViewModel()
) {
    val uiState by rocketViewModel.uiState.collectAsStateWithLifecycle()
    RocketLaunchList(rockets = uiState.rocketItems)
}

@Composable
fun RocketLaunchList(rockets: List<RocketItemUiState>) {
    LazyColumn(modifier = Modifier.padding(8.dp)) {
        items(rockets) { rocket ->
            RocketCardView(rocket = rocket)
        }
    }
}

@Composable
fun RocketCardView(rocket: RocketItemUiState) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = rocket.mission,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = rocket.launchYear,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Gray,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = rocket.flightNumber,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = rocket.details ?: "No details",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Gray,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun RocketCardViewPreview() {
    MyApplicationTheme {
        RocketCardView(
            RocketItemUiState(
                mission = "FalconSat",
                launchYear = "2006-03-24T22:30:00.000Z",
                details = "Successful first stage burn and transition to second stage, maximum altitude 289 km, Premature engine shutdown at T+7 min 30 s, Failed to reach orbit, Failed to recover first stage",
                flightNumber = "12",
            )
        )
    }
}

@Preview
@Composable
fun RocketListPreview() {
    MyApplicationTheme {
        RocketLaunchList(
            rockets = listOf(
                RocketItemUiState(
                    mission = "Falcon1",
                    launchYear = "2006-03-24T22:30:00.000Z",
                    details = "Successful first stage burn and transition to second stage, maximum altitude 289 km, Premature engine shutdown at T+7 min 30 s, Failed to reach orbit, Failed to recover first stage",
                    flightNumber = "1",
                ), RocketItemUiState(
                    mission = "Falcon2",
                    launchYear = "2006-03-24T22:30:00.000Z",
                    details = "Successful first stage burn and transition to second stage, maximum altitude 289 km, Premature engine shutdown at T+7 min 30 s, Failed to reach orbit, Failed to recover first stage",
                    flightNumber = "12",
                ), RocketItemUiState(
                    mission = "Falcon3",
                    launchYear = "2006-03-24T22:30:00.000Z",
                    details = "Successful first stage burn and transition to second stage, maximum altitude 289 km, Premature engine shutdown at T+7 min 30 s, Failed to reach orbit, Failed to recover first stage",
                    flightNumber = "13",
                )
            )
        )
    }
}