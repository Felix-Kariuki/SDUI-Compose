package com.flexcode.sduicompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Laptop
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.flexcode.sduicompose.BuildHomeScreen
import com.flexcode.sduicompose.designsystem.components.SDUIImage
import com.flexcode.sduicompose.designsystem.components.SduiText
import com.flexcode.sduicompose.designsystem.extension.heightDp
import com.flexcode.sduicompose.designsystem.extension.size
import com.flexcode.sduicompose.designsystem.preview.SDUIPreview
import com.flexcode.sduicompose.designsystem.serverUiBuilders.toTypography
import com.flexcode.sduicompose.designsystem.theme.SDUIComposeTheme
import com.flexcode.sduicompose.designsystem.theme.spacing
import com.flexcode.sduicompose.domain.models.DpSizeUi
import com.flexcode.sduicompose.domain.models.ImageUi
import com.flexcode.sduicompose.domain.models.ListTextUi
import kotlin.random.Random

@Composable
fun ImageComponent(
    modifier: Modifier = Modifier,
    imageUi: ImageUi,
    testStyles: ListTextUi
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceVariant),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small)
    ) {
        SDUIImage(
            image = imageUi.url,
            modifier = modifier
                .clip(MaterialTheme.shapes.medium)
                .height(testStyles.heightImage.dp)
        )

        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SduiText(
                text = imageUi.title,
                style = testStyles.titleFontWeight.toTypography().copy(
                    fontSize = testStyles.titleSize.sp
                )
            )
        }

        SduiText(
            text = imageUi.short_description,
            style = testStyles.subTitleFontWeight.toTypography().copy(
                fontSize = testStyles.subTitleSize.sp
            )
        )

        Row(
            modifier
                .fillMaxWidth()
                .padding(end = MaterialTheme.spacing.small),
            horizontalArrangement = Arrangement.End
        ) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.large)
            ) {

                Icon(
                    imageVector = Icons.Filled.Laptop, contentDescription = null,
                    tint = MaterialTheme.colorScheme.onBackground
                )

            }
        }

        Spacer(modifier = modifier.height(MaterialTheme.spacing.small))
    }


}

val sampleImageUi: ImageUi
    get() = ImageUi(
        url = Random.nextInt(10000).toString(),
        scaleType = "crop",
        size = DpSizeUi(0, 250),
        title = "PUBG",
        short_description = ""

    )

private val sampleStyles: ListTextUi
    get() = ListTextUi(
        subTitleSize = 20,
        subTitleFontWeight = "bold",
        titleFontWeight = "bold",
        titleSize = 22,
        heightImage = 200,
        widthImage = 0
    )

@SDUIPreview
@Composable
private fun ImageComponentPreview(modifier: Modifier = Modifier) {
    SDUIComposeTheme {
        ImageComponent(imageUi = sampleImageUi, testStyles = sampleStyles)
    }
}

