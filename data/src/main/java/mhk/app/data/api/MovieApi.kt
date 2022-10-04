package mhk.app.data.api

import mhk.app.domain.model.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query(
            "api_key"
        ) apiKey: String,
        @Query("page") page: Int = 1,
    ): Response<MovieList>
}