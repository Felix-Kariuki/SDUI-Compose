package com.flexcode.sduicompose.designsystem.extension

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.flexcode.sduicompose.domain.models.DpSizeUi

fun DpSizeUi.widthDp(): Dp = width.dp

fun DpSizeUi.heightDp(): Dp = height.dp

@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.size(dpSizeUi: DpSizeUi): Modifier = composed {
    val configuration = LocalConfiguration.current
    val width = if (dpSizeUi.width == 0) {
        configuration.screenWidthDp.dp
    } else {
        dpSizeUi.widthDp()
    }
    val height = if (dpSizeUi.height == 0) {
        configuration.screenHeightDp.dp
    } else {
        dpSizeUi.heightDp()
    }
    size(width = width, height = height)
}
