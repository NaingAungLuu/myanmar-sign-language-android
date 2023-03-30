package org.khawthwarmal.burmesehandsign.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.khawthwarmal.burmesehandsign.dictionary.data.DictionaryProvider
import org.khawthwarmal.burmesehandsign.dictionary.data.DictionaryProviderImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DictionaryModule {

    @Binds
    @Singleton
    abstract fun bindDictionaryProvider(
        dictionaryProvider: DictionaryProviderImpl
    ): DictionaryProvider
}