package org.khawthwarmal.burmesehandsign.dictionary.ui.screen.word.detail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import org.khawthwarmal.burmesehandsign.dictionary.data.DictionaryProvider
import javax.inject.Inject

@HiltViewModel
class WordDetailViewModel @Inject constructor(
    private val dictionaryProvider : DictionaryProvider
): ViewModel() {

    fun getWord(id: String) = flow {
        emit(dictionaryProvider.get().query(id))
    }

}