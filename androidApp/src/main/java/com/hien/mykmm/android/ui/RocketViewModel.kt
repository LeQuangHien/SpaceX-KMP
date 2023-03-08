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
    val externalLink: String? = null
)

data class RocketItemUiState(
    val mission: String,
    val launchYear: String,
    val flightNumber: String,
    val details: String?,
    val article: String?
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
                    details = it.details,
                    article = it.links.article
                )
            }
            _uiState.update {
                it.copy(rocketItems = items)
            }
        }
    }

    fun onItemClicked(article: String?) {
        _uiState.update {
            it.copy(externalLink = article)
        }
    }

    fun resetExternalLink() {
        _uiState.update {
            it.copy(externalLink = null)
        }
    }
}