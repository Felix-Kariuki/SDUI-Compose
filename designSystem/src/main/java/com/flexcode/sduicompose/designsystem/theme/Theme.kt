package com.flexcode.sduicompose.designsystem.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryPink,
    onPrimary = OnPrimary,
    inversePrimary = TextGrayDark,
    primaryContainer = PinkDisabled,
    onPrimaryContainer = OnPrimary,
    secondary = SecondaryContainer,
    onSecondary = BackgroundLight,
    onSurface = BackgroundDark,
    error = Red,
    onError = OnPrimary,
    tertiaryContainer = SuccessGreen,
    background = BackgroundDark,
    surfaceVariant = BackgroundVariantDark,
    onSurfaceVariant = HintGray,
    outline = BorderGrayDark,
    inverseSurface = ButtonSurfaceVariantDark,
    inverseOnSurface = ButtonOnSurfaceVariantDark,

    )

private val LightColorScheme = lightColorScheme(
    primary = PrimaryPink,
    onPrimary = OnPrimary,
    inversePrimary = TextGray,
    primaryContainer = PinkDisabled,
    onPrimaryContainer = OnPrimary,
    secondary = SecondaryContainerLight,
    onSecondary = BackgroundLight,
    onSurface = BackgroundLight,
    error = Red,
    onError = OnPrimary,
    tertiaryContainer = SuccessGreen,
    background = OnPrimary,
    surfaceVariant = BackgroundVariantLight,
    onSurfaceVariant = HintGray,
    outline = BorderGray,
    inverseSurface = ButtonSurfaceVariant,
    inverseOnSurface = ButtonOnSurfaceVariant,

    )


@Composable
fun SDUIComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    CompositionLocalProvider(
        LocalSpacing provides spacing()
        ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}