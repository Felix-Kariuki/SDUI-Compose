package com.flexcode.sduicompose.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class GamesUi(
    val version: Int,
    val games: TimelineBottomUi
) : UiComponent

@Serializable
data class ImageUi(
    val title: String = "",
    val short_description: String,
    val url: String,
    val size: DpSizeUi = DpSizeUi(0, 0),
    val scaleType: String,
    val handler: Handler? = null
) : UiComponent

@Serializable
data class TimelineBottomUi(
    override val order: Int,
    val title: TextUi,
    val list: ListUi
) : OrderedUiComponent