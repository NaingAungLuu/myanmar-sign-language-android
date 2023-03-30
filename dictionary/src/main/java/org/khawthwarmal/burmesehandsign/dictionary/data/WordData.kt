package org.khawthwarmal.burmesehandsign.dictionary.data

import kotlinx.serialization.Serializable

@Serializable
data class DictionaryResponse(
    val words: List<WordData>
)

@Serializable
data class WordData(
    val title: String,
    val description: String,
    val definition: WordDefinitionData,
    val examples: List<String>
)

@Serializable
data class WordDefinitionData(
    val handSign: ImageResourceData,
    val alphabet: ImageResourceData
)

@Serializable
data class ImageResourceData(
    val type: ImageResourceDataType,
    val value: String
)

@Serializable
enum class ImageResourceDataType {
    IMAGE,
    GIF,
    Url
}
