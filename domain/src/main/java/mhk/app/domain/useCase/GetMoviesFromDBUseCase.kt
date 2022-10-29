package mhk.app.domain.useCase

import mhk.app.domain.repository.MovieRepository

class GetMoviesFromDBUseCase(val movieRepository: MovieRepository) {

    operator fun invoke(movieID: Int) = movieRepository.getMoviesFromDB(movieID)

}