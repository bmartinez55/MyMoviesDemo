package c.bmartinez.mymoviesdemo.data

import com.google.gson.annotations.SerializedName
import java.util.*

//Data Model for the Response returned from the TMDB API
data class MovieDataResponse(
    @SerializedName("results")
    val results: List<Movies>
)

//Data Model for TMDB Movie Item
data class Movies(
    @SerializedName("id")
    val id: Int,
    @SerializedName("vote_average")
    val vote_average: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("poster_path")
    val poster_path: String,
    @SerializedName("release_date")
    val release_date: String,
    @SerializedName("genres")
    val genres: List<Int>
)