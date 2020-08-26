package c.bmartinez.mymoviesdemo.data

import com.google.gson.annotations.SerializedName

//data class MovieData(
//    val movies: List<Movies>
//)

data class Movies(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("year")
    val year: String,
    @SerializedName("genres")
    val genres: List<String>,
    @SerializedName("duration")
    val duration: String,
    @SerializedName("releaseDate")
    val releaseDate: String,
    @SerializedName("storyline")
    val storyline: String,
    @SerializedName("actors")
    val actors: List<String>,
    @SerializedName("posturl")
    val posterurl: String,
    val ratings: List<MovieRatings>
)

data class MovieRatings(
    @SerializedName("id")
    val id: String,
    @SerializedName("ratings")
    val ratings: List<Int>
)