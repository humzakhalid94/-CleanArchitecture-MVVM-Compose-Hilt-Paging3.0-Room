package mhk.app.cleanarchitecture.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mhk.app.data.db.MovieDao
import mhk.app.data.repository.dataSource.MovieLocalDataSource
import mhk.app.data.repository.dataSourceImpl.MovieLocalDataSourceImpl


@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {
    @Provides
    fun provideLocalDataSource(movieDao: MovieDao): MovieLocalDataSource =
        MovieLocalDataSourceImpl(movieDao = movieDao)
}