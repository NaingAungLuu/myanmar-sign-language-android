package org.khawthwarmal.burmesehandsign.dictionary.ui.screen.word

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.khawthwarmal.burmesehandsign.core.ui.theme.headerStyle
import org.khawthwarmal.burmesehandsign.core.ui.theme.notoSan

@Composable
fun WordDescription(
    descriptionText: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = descriptionText,
        style = headerStyle(),
        fontFamily = FontFamily(listOf(notoSan())),
        textAlign = TextAlign.Start,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    )
}