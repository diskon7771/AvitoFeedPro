
package ru.avito.feedpro.data.photo.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.avito.feedpro.data.photo.ImageProcessor
import ru.avito.feedpro.data.photo.PhotoRepositoryImpl
import ru.avito.feedpro.domain.repository.PhotoRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PhotoModule {

    @Provides
    @Singleton
    fun provideProcessor(): ImageProcessor = ImageProcessor()

    @Provides
    @Singleton
    fun providePhotoRepository(
        processor: ImageProcessor
    ): PhotoRepository =
        PhotoRepositoryImpl(processor)
}
