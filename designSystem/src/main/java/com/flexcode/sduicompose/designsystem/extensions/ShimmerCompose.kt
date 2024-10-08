package com.flexcode.sduicompose.designsystem.extensions

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize

fun Modifier.shimmerEffect(): Modifier =
    composed {
        var size by remember {
            mutableStateOf(IntSize.Zero)
        }
        val transition = rememberInfiniteTransition(label = "shimer_transition")
        val startOffsetX by transition.animateFloat(
            initialValue = -2 * size.width.toFloat(),
            targetValue = 2 * size.width.toFloat(),
            animationSpec =
            infiniteRepeatable(
                animation = tween(1500),
            ),
            label = "shimmer_modifier",
        )

        background(
            brush =
            linearGradient(
                colors =
                listOf(
                    Color(0xFFF5F3F3),
                    Color(0xFFF2EAEA),
                    Color(0xFFF5F3F3),
                ),
                start = Offset(startOffsetX, 0f),
                end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat()),
            ),
        )
            .onGloballyPositioned {
                size = it.size
            }
    }

@Composable
fun shimmerEffect(
    showShimmer: Boolean = true,
    targetValue: Float = 1300f,
): Brush {
    return if (showShimmer) {
        val shimmerColors =
            listOf(
                Color(0xFFF5F3F3),
                Color(0xFFF2EAEA),
                Color(0xFFF5F3F3),
            )

        val transition = rememberInfiniteTransition(label = "shimmer_background_transition")
        val translateAnimation =
            transition.animateFloat(
                initialValue = 0f,
                targetValue = targetValue,
                animationSpec =
                infiniteRepeatable(
                    animation = tween(2000),
                    repeatMode = RepeatMode.Restart,
                ),
                label = "shimmer_background",
            )
        linearGradient(
            colors = shimmerColors,
            start = Offset.Zero,
            end = Offset(x = translateAnimation.value, y = translateAnimation.value),
        )
    } else {
        linearGradient(
            colors = listOf(Color.Transparent, Color.Transparent),
            start = Offset.Zero,
            end = Offset.Zero,
        )
    }
}
