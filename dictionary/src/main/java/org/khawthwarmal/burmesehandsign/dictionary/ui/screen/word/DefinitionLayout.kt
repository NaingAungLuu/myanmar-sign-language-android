package org.khawthwarmal.burmesehandsign.dictionary.ui.screen.word

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.khawthwarmal.burmesehandsign.core.models.ImageResource
import org.khawthwarmal.burmesehandsign.core.models.WordDefinition
import org.khawthwarmal.burmesehandsign.dictionary.R

@Composable
fun DefinitionLayout(
    data: WordDefinition,
    modifier: Modifier = Modifier
) {

    // States
    val toggleState = remember { mutableStateOf(DefinitionType.HandSign) }

    Column(modifier = modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .padding(horizontal = 24.dp)
                .clip(RoundedCornerShape(15.dp))

        ) {
            when (toggleState.value) {
                DefinitionType.HandSign -> HandSignLayout(data.handSign)
                DefinitionType.Alphabet -> AlphabetLayout(data.alphabet)
            }
        }
        DefinitionTypeToggle(toggleState)
    }
}

enum class DefinitionType { HandSign, Alphabet }

@Preview(showBackground = false)
@Composable
fun PreviewDefinitionLayout() {
    Column(Modifier.padding(top = 20.dp)) {
        DefinitionLayout(
            data = WordDefinition(
                handSign = ImageResource.LocalGIF(R.drawable.alphabet_ka_gyi_hand_sign),
                alphabet = ImageResource.LocalImage(R.drawable.alphabet_ka_kyi_example_1)
            )
        )
    }
}