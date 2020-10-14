package c.bmartinez.mymoviesdemo.data

import com.google.gson.annotations.SerializedName

//Data Model for the Movie Response
data class MovieDataResponse(
    @SerializedName("results")
    val results: List<Movies>
)

//Data Model for the Genre Response
data class MovieGenreResponse(
    @SerializedName("genres")
    val genres: List<MovieGenre>
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
    @SerializedName("genres_ids")
    val genresIDs: List<Int>
)

//Data Model for TMDB Movie Genre
data class MovieGenre(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)