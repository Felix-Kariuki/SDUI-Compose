package com.flexcode.sduicompose.data

import com.flexcode.sduicompose.domain.models.GamesUi
import com.flexcode.sduicompose.domain.repository.GamesRepository
import com.google.firebase.database.DatabaseReference
import com.skydoves.firebase.database.ktx.flow
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.json.Json
import javax.inject.Inject

class GamesRepositoryImpl @Inject constructor(
    private val databaseReference: DatabaseReference,
    private val json: Json
) : GamesRepository {
    override fun fetchGamesUi(): Flow<Result<GamesUi?>> {
        return databaseReference.flow(
            path = { snapshot ->
                snapshot.child("gamesCompose")
            },
            decodeProvider = { jsonString ->
                json.decodeFromString(jsonString)
            }
        )
    }
}