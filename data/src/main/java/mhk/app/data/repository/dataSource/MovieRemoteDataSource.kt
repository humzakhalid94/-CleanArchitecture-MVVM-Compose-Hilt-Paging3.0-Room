package mhk.app.data.repository.dataSource

import mhk.app.domain.model.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getPopularMovies(): Response<MovieList>
}