package org.khawthwarmal.burmesehandsign.dictionary.data

import android.annotation.SuppressLint
import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import org.khawthwarmal.burmesehandsign.core.models.Dictionary
import org.khawthwarmal.burmesehandsign.core.models.Example
import org.khawthwarmal.burmesehandsign.core.models.ImageResource
import org.khawthwarmal.burmesehandsign.core.models.Word
import org.khawthwarmal.burmesehandsign.core.models.WordDefinition
import java.util.*
import javax.inject.Inject

class DictionaryMapper @Inject constructor(
    @ApplicationContext private val context: Context
) {
    fun map(input: DictionaryResponse): Dictionary = DictionaryImpl(
        words = input.words.map(::map)
    )

    fun map(input: WordData): Word = Word(
        title = input.title,
        description = input.description,
        definition = map(input.definition),
        examples = input.examples.map {
            Example.Image(ImageResource.LocalImage(resolveResource(it)))
        }
    )

    fun map(input: WordDefinitionData): WordDefinition = WordDefinition(
        handSign = map(input.handSign),
        alphabet = map(input.alphabet)
    )

    fun map(input: ImageResourceData): ImageResource = when(input.type) {
        ImageResourceDataType.IMAGE -> ImageResource.LocalImage(resolveResource(input.value))
        ImageResourceDataType.GIF ->  ImageResource.LocalGIF(resolveResource(input.value))
        ImageResourceDataType.Url ->  ImageResource.Url(input.value)
    }

    @SuppressLint("DiscouragedApi")
    private fun resolveResource(value: String): Int {
        return context.resources.getIdentifier(value, "drawable", context.packageName)
    }
}