package org.khawthwarmal.burmesehandsign.dictionary.data

import org.khawthwarmal.burmesehandsign.core.models.Dictionary
import org.khawthwarmal.burmesehandsign.core.models.Word

class DictionaryImpl(
    override val words: List<Word>
): Dictionary {

    override fun query(id: String): Word {
        val word = words.find { it.title == id }
        checkNotNull(word)
        return word
    }

    override fun queryList(word: String): List<Word> {
        return words.filter {
            it.title.contains(word) || it.description.contains(word)
        }
    }
}