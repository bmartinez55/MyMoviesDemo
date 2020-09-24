package c.bmartinez.mymoviesdemo.data

import com.google.gson.annotations.SerializedName

//Data Model for the Response returned from the TMDB API
//data class MovieDataResponse(
//    val movies: List<Movies>
//)

//Data Model for TMDB Movie Item
data class Movies(
    val id: Int,
    val vote_average: Double,
    val title: String,
    val overview: String,
    val adult: Boolean,
    val poster_path: String,
    val release_date: String
)