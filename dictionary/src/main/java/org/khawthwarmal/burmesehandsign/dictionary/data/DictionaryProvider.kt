package org.khawthwarmal.burmesehandsign.dictionary.data

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import org.khawthwarmal.burmesehandsign.core.models.Dictionary
import org.khawthwarmal.burmesehandsign.dictionary.R
import javax.inject.Inject

@OptIn(ExperimentalSerializationApi::class)
class DictionaryProviderImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val dictionaryMapper: DictionaryMapper
) : DictionaryProvider {
    override fun get(): Dictionary {
        val dictionaryData = Json.decodeFromStream<DictionaryResponse>(
            context.resources.openRawResource(R.raw.dictionary)
        )
        return dictionaryMapper.map(dictionaryData)
    }

}

interface DictionaryProvider {
    fun get(): Dictionary
}