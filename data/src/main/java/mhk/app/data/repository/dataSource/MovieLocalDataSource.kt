package mhk.app.data.repository.dataSource

import mhk.app.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieLocalDataSource {
    fun getMoviesFromDB(movieId : Int): Flow<Movie>
}