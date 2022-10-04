package mhk.app.domain.model

import com.google.gson.annotations.SerializedName
import mhk.app.domain.model.Movie
import java.io.Serializable

data class MovieList(
    @SerializedName("page")
    val page: Int = 1,
    @SerializedName("results")
    val movies: List<Movie>,
) : Serializable