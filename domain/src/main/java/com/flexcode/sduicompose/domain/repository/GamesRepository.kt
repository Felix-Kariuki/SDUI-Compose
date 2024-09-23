package com.flexcode.sduicompose.domain.repository

import com.flexcode.sduicompose.domain.models.GamesUi
import kotlinx.coroutines.flow.Flow

interface GamesRepository {
  fun fetchGamesUi(): Flow<Result<GamesUi?>>
}
