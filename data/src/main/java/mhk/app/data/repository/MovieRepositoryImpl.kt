package mhk.app.data.repository

import kotlinx.coroutines.flow.Flow
import mhk.app.data.repository.dataSource.MovieLocalDataSource
import mhk.app.data.repository.dataSource.MovieRemoteDataSource
import mhk.app.domain.model.Movie
import mhk.app.domain.model.MovieList
import mhk.app.domain.util.Result
import mhk.app.domain.repository.MovieRepository
import retrofit2.Response


class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
) : MovieRepository {


    override fun getPopularMovies() =
        movieRemoteDataSource.getPopularMovies()

    override fun getMoviesFromDB(movieId: Int): Flow<Movie> =
        movieLocalDataSource.getMoviesFromDB(movieId)
}