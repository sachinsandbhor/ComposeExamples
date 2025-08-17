package com.shreejacreation.composesample

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shreejacreation.composesample.ui.theme.ComposeSampleTheme

@Composable
fun TaskManger(modifier: Modifier = Modifier, message1: String, message2: String) {
    val image = painterResource(R.drawable.ic_task_completed)
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = modifier.padding(top = 24.dp, bottom = 8.dp),
            text = message1,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = modifier.padding(16.dp),
            text = message2,
            fontSize = 16.sp
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "my preview"
)
@Composable
fun TaskManagerPreview() {
    ComposeSampleTheme {
        TaskManger(message1 = "Hi there", message2 = "nice work")
    }
}
