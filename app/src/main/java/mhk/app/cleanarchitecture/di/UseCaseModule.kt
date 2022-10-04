package mhk.app.cleanarchitecture.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mhk.app.domain.repository.MovieRepository
import mhk.app.domain.useCase.GetPopularMoviesUseCase

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetPopularMoviesUseCase(movieRepository: MovieRepository) =
       GetPopularMoviesUseCase(movieRepository)
}