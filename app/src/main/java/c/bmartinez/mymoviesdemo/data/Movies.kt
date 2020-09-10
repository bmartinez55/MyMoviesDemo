package c.bmartinez.mymoviesdemo.data

import com.google.gson.annotations.SerializedName

data class MovieDataResponse(
    val movies: List<Movies>
)

data class Movies(
    val id: Int,
    val vote_average: Double,
    val title: String,
    val overview: String,
    val adult: Boolean,
    val poster_path: String,
    val release_date: String
)