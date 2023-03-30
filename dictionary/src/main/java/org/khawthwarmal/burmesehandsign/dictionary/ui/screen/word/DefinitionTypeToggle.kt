package org.khawthwarmal.burmesehandsign.dictionary.ui.screen.word

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.khawthwarmal.burmesehandsign.core.ui.theme.mediumBodyStyle

@Composable
fun DefinitionTypeToggle(
    toggleState: MutableState<DefinitionType>,
    alphabetLabel: String = "Alphabet",
    handSignLabel: String = "Hand Sign"
) {
    val handSignContentColor by animateColorAsState(
        targetValue = when (toggleState.value) {
            DefinitionType.HandSign -> Color.Black
            DefinitionType.Alphabet -> Color.White
        }
    )
    val alphabetContentColor by animateColorAsState(
        targetValue = when(toggleState.value) {
            DefinitionType.HandSign -> Color.White
            DefinitionType.Alphabet -> Color.Black
        }
    )
    val handSignBackgroundColor by animateColorAsState(
        targetValue = when (toggleState.value) {
            DefinitionType.HandSign -> Color.White
            DefinitionType.Alphabet -> Color.Black
        }
    )
    val alphabetBackgroundColor by animateColorAsState(
        targetValue = when (toggleState.value) {
            DefinitionType.HandSign -> Color.Black
            DefinitionType.Alphabet -> Color.White
        }
    )

    Box(
        modifier = Modifier
            .offset(y = (-24).dp)
            .padding(horizontal = 56.dp)
            .clip(RoundedCornerShape(50.dp))
            .background(Color.Black)
    ) {
        Row(Modifier.padding(8.dp)) {
            Text(
                text = handSignLabel,
                style = mediumBodyStyle(),
                color = handSignContentColor,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(0.1f)
                    .clickable { toggleState.value = DefinitionType.HandSign }
                    .clip(RoundedCornerShape(50.dp))
                    .background(color = handSignBackgroundColor)
                    .padding(vertical = 8.dp, horizontal = 16.dp)
            )
            Text(
                text = alphabetLabel,
                style = mediumBodyStyle(),
                color = alphabetContentColor,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(0.1f)
                    .clickable { toggleState.value = DefinitionType.Alphabet }
                    .clip(RoundedCornerShape(50.dp))
                    .background(color = alphabetBackgroundColor)
                    .padding(vertical = 8.dp, horizontal = 16.dp)
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
private fun PreviewDefinitionTypeToggle() {
    Column {
        val state = remember { mutableStateOf(DefinitionType.HandSign) }
        Spacer(Modifier.height(48.dp))
        DefinitionTypeToggle(state)
    }
}