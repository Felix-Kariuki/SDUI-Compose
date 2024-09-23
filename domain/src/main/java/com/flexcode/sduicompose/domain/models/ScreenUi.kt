package com.flexcode.sduicompose.domain.models

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

@Immutable
@Serializable
data class ScreenUi(
  val version: Int?,
  val components: List<UiComponent>
)