package com.shreejacreation.composesample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shreejacreation.composesample.ui.theme.ComposeSampleTheme

@Composable
fun Quadrant(modifier: Modifier = Modifier, text1: String, text2: String, backgroundColor: Color) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text1,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = text2,
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
fun QuadrantPreview() {
    ComposeSampleTheme {
        Quadrant(text1 = "Hi there", text2 = "nice work", backgroundColor = MaterialTheme.colorScheme.onPrimary)
    }
}
