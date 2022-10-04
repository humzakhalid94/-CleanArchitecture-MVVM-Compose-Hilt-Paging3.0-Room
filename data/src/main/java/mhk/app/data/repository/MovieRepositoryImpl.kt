package mhk.app.data.repository

import mhk.app.data.repository.dataSource.MovieRemoteDataSource
import mhk.app.domain.model.MovieList
import mhk.app.domain.util.Result
import mhk.app.domain.repository.MovieRepository
import retrofit2.Response


class MovieRepositoryImpl(private val movieRemoteDataSource: MovieRemoteDataSource): MovieRepository {

    override suspend fun getPopularMovies()  =  responseToRequest(movieRemoteDataSource.getPopularMovies())

    private fun responseToRequest(response: Response<MovieList>) : Result<MovieList>{
        if(response.isSuccessful){
            response.body()?.let {result->
                return Result.Success(result)
            }
        }
        return Result.Error(response.message())
    }
}