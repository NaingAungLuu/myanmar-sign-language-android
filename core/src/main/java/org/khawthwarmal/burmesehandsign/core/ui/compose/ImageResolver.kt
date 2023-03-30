package org.khawthwarmal.burmesehandsign.core.ui.compose

import android.os.Build
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import org.khawthwarmal.burmesehandsign.core.R
import org.khawthwarmal.burmesehandsign.core.models.ImageResource

@Composable
fun imageResource(
    resource: ImageResource
) : Painter = when (resource) {
    is ImageResource.LocalGIF -> getGifPainter(resId = resource.resId)
    is ImageResource.LocalImage -> painterResource(id = resource.resId)
    is ImageResource.Url -> getUrlImagePainter(url = resource.urlPath)
}

@Composable
private fun getGifPainter(
    @DrawableRes resId: Int
): Painter {
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (Build.VERSION.SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()

    return rememberAsyncImagePainter(
        model = resId,
        imageLoader = imageLoader,
        placeholder = painterResource(id = R.drawable.ic_image_placeholder),
        fallback = painterResource(id = R.drawable.ic_image_placeholder),
        error = painterResource(id = R.drawable.ic_image_placeholder)
    )
}

@Composable
private fun getUrlImagePainter(url: String) : Painter = rememberAsyncImagePainter(
    model = url,
    placeholder = painterResource(id = R.drawable.ic_image_placeholder),
    fallback = painterResource(id = R.drawable.ic_image_placeholder),
    error = painterResource(id = R.drawable.ic_image_placeholder)
)