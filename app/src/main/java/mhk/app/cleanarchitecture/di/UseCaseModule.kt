package mhk.app.cleanarchitecture.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mhk.app.domain.repository.MovieRepository
import mhk.app.domain.useCase.GetMoviesFromDBUseCase
import mhk.app.domain.useCase.GetPopularMoviesUseCase
import mhk.app.domain.useCase.MovieUseCases

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideMovieUseCases(movieRepository: MovieRepository) = MovieUseCases(
        getPopularMoviesUseCase = GetPopularMoviesUseCase(movieRepository = movieRepository),
        getMoviesFromDBUseCase = GetMoviesFromDBUseCase(movieRepository = movieRepository)
    )
}