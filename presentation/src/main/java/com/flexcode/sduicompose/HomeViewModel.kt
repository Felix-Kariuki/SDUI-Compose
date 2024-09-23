package com.flexcode.sduicompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flexcode.sduicompose.domain.models.ScreenUi
import com.flexcode.sduicompose.domain.models.buildUiComponentList
import com.flexcode.sduicompose.domain.repository.GamesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: GamesRepository
) : ViewModel() {

    val gamesUi: StateFlow<ScreenUi?> = repository.fetchGamesUi()
        .flatMapLatest { response -> flowOf(response.getOrNull()) }
        .filterNotNull()
        .map {
            ScreenUi(
                version = it.version,
                components = it.buildUiComponentList()
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = null
        )

}
