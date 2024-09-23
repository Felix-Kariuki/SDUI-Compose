package com.flexcode.sduicompose.domain.models

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Immutable
@Serializable
data class ListUi(
    val layout: String,
    val itemSize: DpSizeUi,
    val items: List<ImageUi>,
    val extra: Map<String, JsonElement> = mapOf(),
    val testStyles: ListTextUi
) : UiComponent

@Immutable
@Serializable
data class ListTextUi(
    val subTitleFontWeight: String,
    val subTitleSize: Int,
    val titleFontWeight: String,
    val titleSize: Int,
    val heightImage: Int,
    val widthImage: Int
) : UiComponent

fun String.toLayoutType(): LayoutType {
    return if (this == "grid") LayoutType.GRID
    else if (this == "column") LayoutType.COLUMN
    else LayoutType.ROW
}

enum class LayoutType(val value: String) {
    GRID("grid"), COLUMN("column"), ROW("row")
}
