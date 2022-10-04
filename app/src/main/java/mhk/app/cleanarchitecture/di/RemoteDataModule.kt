package mhk.app.cleanarchitecture.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mhk.app.data.api.MovieApi
import mhk.app.data.repository.dataSource.MovieRemoteDataSource
import mhk.app.data.repository.dataSourceImpl.MovieRemoteDataSourceImpl


@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {
    @Provides
    fun provideMoviesRemoteDataSource(movieApi: MovieApi) : MovieRemoteDataSource =
        MovieRemoteDataSourceImpl(movieApi)
}