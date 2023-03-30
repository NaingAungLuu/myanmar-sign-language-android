package org.khawthwarmal.burmesehandsign.core.models

import androidx.annotation.DrawableRes

sealed class ImageResource(
    val data: Any
) {
    data class Url(
        val urlPath: String
    ) : ImageResource(urlPath)

    data class LocalGIF(
        @DrawableRes val resId: Int
    ) : ImageResource(resId)

    data class LocalImage(
        @DrawableRes val resId: Int
    ) : ImageResource(resId)

}