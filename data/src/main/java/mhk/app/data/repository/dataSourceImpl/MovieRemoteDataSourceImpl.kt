package mhk.app.data.repository.dataSourceImpl

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import mhk.app.data.BuildConfig
import mhk.app.data.api.MovieApi
import mhk.app.data.db.MovieDB
import mhk.app.data.paging.MovieRemoteMediator
import mhk.app.data.repository.dataSource.MovieRemoteDataSource
import mhk.app.domain.model.Movie
import mhk.app.domain.model.MovieList
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val movieApi: MovieApi, private val movieDB: MovieDB) :
    MovieRemoteDataSource {

    private val movieDao = movieDB.movieDao()

//    override suspend fun getPopularMovies() = movieApi.getPopularMovies(BuildConfig.API_KEY)

    @OptIn(ExperimentalPagingApi::class)
    override fun getPopularMovies(): Flow<PagingData<Movie>> {

        val pagingSourceFactory = { movieDao.getAllMovies() }

        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = MovieRemoteMediator(
                movieApi = movieApi,
                movieDB = movieDB
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow

    }

    /*
    *  override fun getPopularMovies(): Flow<PagingData<Movie>> {
        val pagingSourceFactory = { movieDao.getAllMovies() }
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = MovieRemoteMediator(
                movieApi,
                movieDB
            ),
            pagingSourceFactory = pagingSourceFactory,
        ).flow
    }
    * */

}