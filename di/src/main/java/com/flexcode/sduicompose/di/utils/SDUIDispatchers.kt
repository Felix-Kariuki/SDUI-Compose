package com.flexcode.sduicompose.di.utils

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val dispatchers: SDUIDispatchers)

enum class SDUIDispatchers {
    IO, MAIN
}