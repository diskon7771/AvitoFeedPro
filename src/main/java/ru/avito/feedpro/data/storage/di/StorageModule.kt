
package ru.avito.feedpro.data.storage.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import ru.avito.feedpro.data.storage.HistoryRepositoryImpl
import ru.avito.feedpro.data.storage.SettingsDataStore
import ru.avito.feedpro.domain.repository.HistoryRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StorageModule {

    @Provides
    @Singleton
    fun provideSettingsDataStore(
        @ApplicationContext context: Context
    ): SettingsDataStore = SettingsDataStore(context)

    @Provides
    @Singleton
    fun provideHistoryRepository(): HistoryRepository =
        HistoryRepositoryImpl()
}
