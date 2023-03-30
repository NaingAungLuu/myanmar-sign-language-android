package org.khawthwarmal.burmesehandsign.dictionary.ui.screen.word

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import org.khawthwarmal.burmesehandsign.core.models.ImageResource
import org.khawthwarmal.burmesehandsign.core.ui.compose.imageResource

@SuppressLint("DiscouragedApi")
@Composable
fun HandSignLayout(
    data: ImageResource
){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = imageResource(data),
            contentDescription = "hand sign",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}