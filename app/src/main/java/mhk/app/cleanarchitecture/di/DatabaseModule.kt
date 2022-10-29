package com.farhan.tanvir.androidcleanarchitecture.di

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mhk.app.data.db.MovieDB
import mhk.app.data.db.MovieDao
import mhk.app.data.db.MovieRemoteKeysDao

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideDatabase(app: Application): MovieDB =
        Room.databaseBuilder(app, MovieDB::class.java, "movie_db").fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideMovieDao(movieDB: MovieDB): MovieDao = movieDB.movieDao()

    @Provides
    fun provideMovieRemoteKeysDao(movieDB: MovieDB): MovieRemoteKeysDao =
        movieDB.movieRemoteKeysDao()
}