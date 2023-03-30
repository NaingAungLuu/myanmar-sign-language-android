package org.khawthwarmal.burmesehandsign.dictionary.ui.screen.dictionary

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import org.khawthwarmal.burmesehandsign.dictionary.data.DictionaryProvider
import javax.inject.Inject

@HiltViewModel
class DictionaryViewModel @Inject constructor(
    private val dictionaryProvider : DictionaryProvider
): ViewModel() {

    fun getDictionary() = flow {
        emit(dictionaryProvider.get())
    }

}