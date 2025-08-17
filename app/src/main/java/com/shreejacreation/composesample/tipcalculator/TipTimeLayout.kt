package com.shreejacreation.composesample.tipcalculator

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shreejacreation.composesample.R
import com.shreejacreation.composesample.ui.theme.ComposeSampleTheme
import java.text.NumberFormat

@Composable
fun TipTimeLayout(modifier: Modifier = Modifier.fillMaxSize()) {

    var amountInput by remember { mutableStateOf("") }
    var tipInput by remember { mutableStateOf("") }
    var roundTip by remember { mutableStateOf(false) }

    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val tipPercentage = tipInput.toDoubleOrNull() ?: 0.0
    val tip = calculateTip(amount, tipPercentage, roundTip)

    Column(modifier
        .statusBarsPadding()
        .padding(horizontal = 40.dp)
        .verticalScroll(rememberScrollState())
        .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.calculate_tip),
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start)
        )
        Spacer(modifier = Modifier.height(16.dp))
        EditNumberField(
            value = tipInput,
            onValueChanged = { tipInput = it },
            label = R.string.cost_of_service,
            modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            leadingIcon = R.drawable.money_24
        )
        EditNumberField(
            value = amountInput,
            onValueChanged = { amountInput = it },
            label = R.string.how_was_the_service,
            modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            leadingIcon = R.drawable.outline_123_24
        )
        RoundTheTipRow(
            modifier = Modifier.padding(bottom = 32.dp),
            roundTip = roundTip,
            onRoundUpChanged = {roundTip = it})
        Text(
            text = stringResource(R.string.tip_amount, tip),
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.height(150.dp))
    }

}

@Composable
fun EditNumberField(
    value: String,
    onValueChanged: (String) -> Unit,
    @StringRes label:Int,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions,
    @DrawableRes leadingIcon: Int
) {
    TextField(
        value = value,
        onValueChanged,
        label = { Text(stringResource(label)) },
        modifier = modifier.fillMaxWidth(),
        singleLine = true,
        keyboardOptions = keyboardOptions,
        leadingIcon = { Icon(painter = painterResource(leadingIcon), null) }
    )
}

@Composable
fun RoundTheTipRow(
    modifier: Modifier = Modifier,
    roundTip: Boolean,
    onRoundUpChanged: (Boolean) -> Unit
    ) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .size(40.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
       Text(stringResource(R.string.round_up_tip))
        Switch(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End),
            checked = roundTip,
            onCheckedChange = onRoundUpChanged
        )
    }
}

@VisibleForTesting
internal fun calculateTip(amount: Double, tipPercent: Double = 15.0, roundTip: Boolean): String {
    var tip = tipPercent / 100 * amount
    if (roundTip) {
        tip = kotlin.math.ceil(tip)
    }
    return NumberFormat.getCurrencyInstance().format(tip)
}


@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "my preview"
)
@Composable
fun TipTimeLayoutPreview() {
    ComposeSampleTheme {
        TipTimeLayout()
    }
}
