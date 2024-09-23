package com.flexcode.sduicompose.domain.models

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

@Immutable
@Serializable
data class TextUi(
    val text: String,
    val size: Int,
    val fontWeight: String
) : UiComponent