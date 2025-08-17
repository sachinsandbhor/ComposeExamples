package com.shreejacreation.composesample

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shreejacreation.composesample.ui.theme.ComposeSampleTheme

@Composable
fun Lemanade(modifier: Modifier = Modifier) {
    var currentStep by remember { mutableStateOf(1) }
    when (currentStep) {
        1 -> {
            LemonTextWithImage(
                textLabelResourceId = R.string.tap_lemon,
                drawableResourceId = R.drawable.lemon_tree,
                contentDescriptionResourceId = R.string.tap_lemon,
                onImageClick = {
                    currentStep = 2
                }
            )
        }
        2 -> {
            LemonTextWithImage(
                textLabelResourceId = R.string.keep_tapping,
                drawableResourceId = R.drawable.lemon_squeeze,
                contentDescriptionResourceId = R.string.keep_tapping,
                onImageClick = {
                    currentStep = 3
                }
            )
        }
        3 -> {
            LemonTextWithImage(
                textLabelResourceId = R.string.tap_to_drink,
                drawableResourceId = R.drawable.lemon_drink,
                contentDescriptionResourceId = R.string.tap_to_drink,
                onImageClick = {
                    currentStep = 4
                }
            )
        }
        else -> {
            LemonTextWithImage(
                textLabelResourceId = R.string.tap_empty,
                drawableResourceId = R.drawable.lemon_restart,
                contentDescriptionResourceId = R.string.tap_empty,
                onImageClick = {
                    currentStep = 1
                }
            )
        }
    }
}

@Composable
fun LemonTextWithImage(
    textLabelResourceId: Int,
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = onImageClick,
                shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
                colors = ButtonDefaults.buttonColors(contentColor = MaterialTheme.colorScheme.tertiary)
            ) {
                Text(
                    text = stringResource(textLabelResourceId)
                )
                Spacer(modifier = Modifier.height(32.dp))
                Image(
                    painter = painterResource(drawableResourceId),
                    contentDescription = stringResource(contentDescriptionResourceId),
                    modifier = Modifier
                        .width(dimensionResource(R.dimen.button_image_width))
                        .height(dimensionResource(R.dimen.button_image_height))
                        .padding(dimensionResource(R.dimen.button_interior_padding))
                )
            }
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "my preview"
)
@Composable
fun LemanadePreview() {
    ComposeSampleTheme {
        Lemanade()
    }
}
