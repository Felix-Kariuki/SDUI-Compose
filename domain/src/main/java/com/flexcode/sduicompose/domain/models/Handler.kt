package com.flexcode.sduicompose.domain.models

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

@Immutable
@Serializable
data class Handler(
    val type: String,
    val actions: Map<String, String>
)

enum class HandlerType(val value: String) {
    CLICK("click")
}

enum class HandlerAction(val value: String) {
    NAVIGATION("navigation")
}

enum class NavigationHandler(val value: String) {
    TO("to")
}