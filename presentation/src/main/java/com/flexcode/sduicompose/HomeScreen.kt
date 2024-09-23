package com.flexcode.sduicompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.flexcode.sduicompose.components.ImageComponent
import com.flexcode.sduicompose.designsystem.components.SduiText
import com.flexcode.sduicompose.designsystem.serverUiBuilders.toTypography
import com.flexcode.sduicompose.designsystem.theme.spacing
import com.flexcode.sduicompose.domain.models.LayoutType
import com.flexcode.sduicompose.domain.models.ListUi
import com.flexcode.sduicompose.domain.models.ScreenUi
import com.flexcode.sduicompose.domain.models.TextUi
import com.flexcode.sduicompose.domain.models.UiComponent
import com.flexcode.sduicompose.domain.models.toLayoutType

@Composable
fun HomeRootScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val screenUi by viewModel.gamesUi.collectAsStateWithLifecycle()

    if (screenUi != null) {
        screenUi?.let {
            HomeScreen(
                screenUi = it,
            )
        }

    } else {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

@Composable
private fun HomeScreen(
    screenUi: ScreenUi,
) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .padding(
                start = MaterialTheme.spacing.medium,
                end = MaterialTheme.spacing.medium,
                top = 40.dp
            ),
    ) {
        screenUi.components.forEach { uiComponent ->
            uiComponent.BuildHomeScreen()
        }
    }
}

@Composable
fun UiComponent.BuildHomeScreen(
    modifier: Modifier = Modifier,
) {
    when (this) {
        is TextUi -> {
            SduiText(
                text = this.text,
                style = this.fontWeight.toTypography().copy(
                    fontSize = this.size.sp
                )
            )
        }

        is ListUi -> {
            ImagesList(
                listUi = this,
                modifier = modifier,
            )
        }

        else -> {

        }
    }

}

@Composable
fun ImagesList(
    listUi: ListUi,
    modifier: Modifier = Modifier,
) {

    val layoutType = listUi.layout.toLayoutType()

    when (layoutType) {
        LayoutType.COLUMN -> {
            LazyColumn(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = MaterialTheme.spacing.medium),
                contentPadding = PaddingValues(MaterialTheme.spacing.none)
            ) {
                items(items = listUi.items, key = { it.url }) { imageUi ->
                    ImageComponent(imageUi = imageUi, testStyles = listUi.testStyles)
                }
            }
        }

        else -> {
            // handle other types
        }
    }

}