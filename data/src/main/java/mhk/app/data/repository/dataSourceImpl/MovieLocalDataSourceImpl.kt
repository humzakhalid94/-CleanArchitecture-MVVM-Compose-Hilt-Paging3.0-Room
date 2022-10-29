package mhk.app.data.repository.dataSourceImpl

import kotlinx.coroutines.flow.Flow
import mhk.app.data.db.MovieDao
import mhk.app.data.repository.dataSource.MovieLocalDataSource
import mhk.app.domain.model.Movie


class MovieLocalDataSourceImpl(private val movieDao: MovieDao) : MovieLocalDataSource {

    override fun getMoviesFromDB(movieId: Int): Flow<Movie> = movieDao.getMovie(movieId)

}