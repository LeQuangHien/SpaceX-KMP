package com.hien.mykmm.android.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hien.mykmm.data.SpaceXRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class RocketUiState(
    val rocketItems: List<RocketItemUiState> = listOf(),
)

data class RocketItemUiState(
    val mission: String,
    val launchYear: String,
    val flightNumber: String,
    val details: String?,
)

class RocketViewModel(
    private val spaceXRepository: SpaceXRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(RocketUiState())
    val uiState: StateFlow<RocketUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val items: List<RocketItemUiState> = spaceXRepository.getAllLaunches().map {
                RocketItemUiState(
                    mission = it.missionName,
                    launchYear = it.launchYear.toString(),
                    flightNumber = it.flightNumber.toString(),
                    details = it.details
                )
            }
            _uiState.update {
                it.copy(rocketItems = items)
            }
        }
    }
}