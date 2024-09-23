package com.flexcode.sduicompose.designsystem.serverUiBuilders

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

fun String.toFontWeight(): FontWeight {
  return when (this) {
    "bold" -> FontWeight.Bold
    "medium" -> FontWeight.Medium
    else -> FontWeight.Normal
  }
}

@Composable
fun String.toTypography(): TextStyle {
  return when (this) {
    "bold" -> MaterialTheme.typography.titleSmall
    "medium" -> MaterialTheme.typography.bodyLarge
    else -> MaterialTheme.typography.bodyLarge
  }
}

fun String.toContentScale(): ContentScale {
  return when (this) {
    "crop" -> ContentScale.Crop
    "fit" -> ContentScale.Fit
    "fill" -> ContentScale.FillBounds
    else -> ContentScale.None
  }
}