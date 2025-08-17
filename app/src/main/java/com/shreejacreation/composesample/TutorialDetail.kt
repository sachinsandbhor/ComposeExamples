package com.shreejacreation.composesample

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shreejacreation.composesample.ui.theme.ComposeSampleTheme

@Composable
fun TutorialDetail( modifier: Modifier = Modifier, title:String , message1: String, message2: String) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Text(
            modifier = modifier.padding(16.dp),
            text = title,
            fontSize = 24.sp
        )
        Text(
            modifier = modifier.padding(start = 16.dp, end = 16.dp),
            text = message1,
            textAlign = TextAlign.Justify
        )
        Text(
            modifier = modifier.padding(16.dp),
            text = message2,
            textAlign = TextAlign.Justify
        )
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "my preview"
)
@Composable
fun TutorialPreview() {
    ComposeSampleTheme {
        TutorialDetail(title = "Hello", message1 = "hi", message2 = "hello", )
    }
}

