package org.khawthwarmal.burmesehandsign.dictionary.ui.screen.word

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import org.khawthwarmal.burmesehandsign.core.models.ImageResource
import org.khawthwarmal.burmesehandsign.core.ui.compose.imageResource

@Composable
fun AlphabetLayout(
    data: ImageResource
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = imageResource(resource = data),
            contentScale = ContentScale.Crop,
            contentDescription = "Alphabet Description",
            modifier = Modifier.fillMaxSize()
        )
    }
}