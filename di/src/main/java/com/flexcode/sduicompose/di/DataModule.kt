package com.flexcode.sduicompose.di

import com.flexcode.sduicompose.data.GamesRepositoryImpl
import com.flexcode.sduicompose.domain.repository.GamesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@[
Module
InstallIn(SingletonComponent::class)
]
internal interface DataModule {

    @Binds
    fun bindsGamesRepository(gamesRepoImpl: GamesRepositoryImpl): GamesRepository
}
