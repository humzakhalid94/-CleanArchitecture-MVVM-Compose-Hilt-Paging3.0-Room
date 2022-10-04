package mhk.app.domain.repository

import mhk.app.domain.model.MovieList
import mhk.app.domain.util.Result

interface MovieRepository {

    suspend fun getPopularMovies(): Result<MovieList>

}