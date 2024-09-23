package com.flexcode.sduicompose.di

import com.flexcode.sduicompose.di.utils.Dispatcher
import com.flexcode.sduicompose.di.utils.SDUIDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@[
Module
InstallIn(SingletonComponent::class)
]
object DispatchersModule {

    @[
    Provides
    Dispatcher(SDUIDispatchers.IO)
    ]
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}