package com.flexcode.sduicompose.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.flexcode.sduicompose.designsystem.extensions.shimmerEffect

@Composable
fun SDUIImage(
    image: Any?,
    modifier: Modifier = Modifier,
) {
    var showShimmer by remember { mutableStateOf(true) }

    AsyncImage(
        model =
        ImageRequest.Builder(LocalContext.current)
            .data(image)
            .crossfade(true)
            .build(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier =
        modifier
            .fillMaxWidth()
            .background(shimmerEffect()),
        onSuccess = { showShimmer = false },
    )
}