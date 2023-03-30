package org.khawthwarmal.burmesehandsign.core.models

interface Dictionary {
    val words: List<Word>
    fun query(id: String): Word
    fun queryList(word: String): List<Word>
}

data class Word(
    val title: String,
    val description: String,
    val definition: WordDefinition,
    val examples: List<Example>
)

data class WordDefinition(
    val handSign: ImageResource,
    val alphabet: ImageResource
)

sealed class Example {
    data class Image(
        val data: ImageResource
    ) : Example()
}