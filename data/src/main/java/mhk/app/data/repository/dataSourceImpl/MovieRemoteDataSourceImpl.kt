package mhk.app.data.repository.dataSourceImpl

import mhk.app.data.BuildConfig
import mhk.app.data.api.MovieApi
import mhk.app.data.repository.dataSource.MovieRemoteDataSource
import mhk.app.domain.model.MovieList
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val movieApi: MovieApi) : MovieRemoteDataSource {

    override suspend fun getPopularMovies() = movieApi.getPopularMovies(BuildConfig.API_KEY)
}