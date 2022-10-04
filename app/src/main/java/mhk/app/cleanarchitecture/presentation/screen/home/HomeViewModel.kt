package mhk.app.cleanarchitecture.presentation.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mhk.app.domain.model.MovieList
import mhk.app.domain.useCase.GetPopularMoviesUseCase
import javax.inject.Inject
import mhk.app.domain.util.Result

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {
    private val _movieState = mutableStateOf<Result<MovieList>>(Result.Loading())
    val movieState: State<Result<MovieList>> = _movieState
    init {
        getPopularMovies()
    }

    private fun getPopularMovies() {
        viewModelScope.launch {
          _movieState.value =  getPopularMoviesUseCase()
        }
    }
}