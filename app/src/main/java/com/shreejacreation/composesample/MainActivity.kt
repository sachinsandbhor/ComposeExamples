package com.shreejacreation.composesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shreejacreation.composesample.ui.theme.ComposeSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeSampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Lemanade()
                }
            }
        }
    }
}

/**
//GreetingImage(message = stringResource(R.string.happy_birthday), from = "Shreeja")
/*TutorialDetail(
modifier = Modifier,
title = stringResource(R.string.title),
message1 = stringResource(R.string.message1),
message2 = stringResource(R.string.message2)
)*/
/*TaskManger(
modifier = Modifier,
message1 = stringResource(R.string.task_manager_text1),
message2 = stringResource(R.string.task_manager_text2)
)*/
//QuadrantApp()
//DicaApp()
 */

@Composable
fun QuadrantApp() {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.weight(1f)) {
            Quadrant(
                modifier = Modifier.weight(1f),
                text1 = "Hi",
                text2 = "Heeloooo",
                backgroundColor = Color(0xFFEADDFF)
            )
            Quadrant(
                modifier = Modifier.weight(1f),
                text1 = "Hi",
                text2 = "Heeloooo",
                backgroundColor = Color(0xFFD0BCFF),
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            Quadrant(
                modifier = Modifier.weight(1f),
                text1 = "Hi",
                text2 = "Heeloooo",
                backgroundColor = Color(0xFFB69DF8),
            )
            Quadrant(
                modifier = Modifier.weight(1f),
                text1 = "Hi",
                text2 = "Heeloooo",
                backgroundColor = Color(0xFFF6EDFF),
            )
        }

    }
}

@Composable
fun GreetingText(
    modifier: Modifier = Modifier,
    message: String,
    from: String
) {
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center,
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun GreetingImage(
    modifier: Modifier = Modifier,
    message: String,
    from: String
) {
    val image = painterResource(R.drawable.androidparty)
    Box(modifier = modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(message = message, from = from)
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "my preview"
)
@Composable
fun GreetingPreview() {
    ComposeSampleTheme {
        GreetingImage(message = "Happy birthday!!!", from = "Shreeja")
    }
}
