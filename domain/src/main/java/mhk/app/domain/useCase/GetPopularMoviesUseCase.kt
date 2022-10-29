package mhk.app.domain.useCase

import mhk.app.domain.repository.MovieRepository

class GetPopularMoviesUseCase(private val movieRepository: MovieRepository) {
    operator fun invoke() = movieRepository.getPopularMovies()
}