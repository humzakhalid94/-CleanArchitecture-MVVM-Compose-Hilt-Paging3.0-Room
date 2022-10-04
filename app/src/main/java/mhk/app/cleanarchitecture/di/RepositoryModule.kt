package mhk.app.cleanarchitecture.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mhk.app.data.repository.MovieRepositoryImpl
import mhk.app.data.repository.dataSource.MovieRemoteDataSource
import mhk.app.domain.repository.MovieRepository


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideMoviesRepository(movieRemoteDataSource: MovieRemoteDataSource) : MovieRepository =
        MovieRepositoryImpl(movieRemoteDataSource)
}