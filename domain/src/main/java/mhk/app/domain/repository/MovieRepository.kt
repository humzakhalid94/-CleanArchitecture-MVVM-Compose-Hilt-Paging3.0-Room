package mhk.app.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import mhk.app.domain.model.Movie
import mhk.app.domain.model.MovieList
import mhk.app.domain.util.Result


interface MovieRepository {
    fun getPopularMovies(): Flow<PagingData<Movie>>

    fun getMoviesFromDB(movieId: Int): Flow<Movie>
}