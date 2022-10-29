package mhk.app.data.repository.dataSource

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import mhk.app.domain.model.Movie
import mhk.app.domain.model.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    fun getPopularMovies(): Flow<PagingData<Movie>>
}