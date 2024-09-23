package com.flexcode.sduicompose.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Spacing for entire app to ensure consistency
 * @property [none] default spacing which is 0.dp
 * @property [extraSmall] the smalled type spacing 4.dp
 * @property [small] 8.dp spacing
 * @property[bigSmall] 12.dp
 * @property [medium] 16.dp spacing used for app's edge to edge (start,end,top,bottom) spacing
 * for holding container columns or surface
 * @property [extraMedium] 24.dp
 * @property [buttonSpacing] text padding for the [com.business.tripitaca.designSystem.compossables.CommonButton]
 * @property [extraLarge]  64.dp spacing
 * @property [large]  32.dp spacing
 * @property [bottomLarge] 120.dp the padding below in views to create a spacing at the bottom of
 * the screen especially in dashboard screen where there are is a bottom sheet
 */
data class Spacing(
    val none: Dp = 0.dp,
    val extraSmall: Dp = 4.dp,
    val buttonSpacing: Dp = 6.dp,
    val small: Dp = 8.dp,
    val bigSmall: Dp = 12.dp,
    val medium: Dp = 16.dp,
    val extraMedium: Dp = 24.dp,
    val large: Dp = 32.dp,
    val extraLarge: Dp = 64.dp,
    val bottomLarge: Dp = 120.dp,
)

/**
 * composition local to allow passing down of spacing
 */
internal val LocalSpacing = compositionLocalOf { Spacing() }

/**
 * Retrieves the current [Spacing] at the call site's position in the hierarchy.
 */
val MaterialTheme.spacing: Spacing
    @Composable
    @ReadOnlyComposable
    get() = LocalSpacing.current

/**
 * function that returns [Spacing]
 * @return [Spacing] top avoid repetition of MaterialTheme.Spacing
 * @see spacing
 */

@Composable
internal fun spacing(): Spacing {
    return MaterialTheme.spacing
}
