package com.flexcode.sduicompose.domain.models

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

/**
 * Represent the dp size of a [UiComponent] in Jetpack Compose.
 *
 * The value 0 is the same as the fill max to the parent.
 * The value -1 is the same as the wrap to the children
 */
@Immutable
@Parcelize
@Serializable
data class DpSizeUi(
    val width: Int,
    val height: Int
) : Parcelable