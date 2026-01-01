
package ru.avito.feedpro.data.ai.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.avito.feedpro.data.ai.AiRepositoryImpl
import ru.avito.feedpro.data.ai.GeminiProvider
import ru.avito.feedpro.domain.repository.AiRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AiModule {

    @Provides
    @Singleton
    fun provideGeminiProvider(): GeminiProvider =
        GeminiProvider(apiKey = "PUT_YOUR_API_KEY_HERE")

    @Provides
    @Singleton
    fun provideAiRepository(
        provider: GeminiProvider
    ): AiRepository =
        AiRepositoryImpl(provider)
}
