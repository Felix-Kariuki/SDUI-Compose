package com.flexcode.sduicompose.designsystem.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.flexcode.sduicompose.designsystem.preview.SDUIPreview
import com.flexcode.sduicompose.designsystem.theme.SDUIComposeTheme

@Composable
fun SduiText(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = MaterialTheme.colorScheme.onBackground,
    style: TextStyle = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp),
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE,
    textPadding: Dp = 0.dp,
    textDecoration: TextDecoration = TextDecoration.None,
    textAlign: TextAlign = TextAlign.Start,
) {
    Text(
        text = text,
        style = style,
        color = textColor,
        maxLines = maxLines,
        overflow = overflow,
        modifier = modifier.padding(textPadding),
        textDecoration = textDecoration,
        textAlign = textAlign,
    )
}

@SDUIPreview
@Composable
private fun MingleTextPreview() {
    SDUIComposeTheme {
        SduiText(text = "SDUI Compose")
    }
}
