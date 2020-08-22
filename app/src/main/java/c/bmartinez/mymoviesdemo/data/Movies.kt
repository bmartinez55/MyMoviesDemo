package c.bmartinez.mymoviesdemo.data

import com.google.gson.annotations.SerializedName

data class Movies(
    val id: String,
    val title: String,
    val year: String,
    val genres: List<String>,
    val duration: String,
    val releasedata: String,
    val storyline: String,
    val actors: List<String>,
    val posterurl: String
)

data class MovieRatings(
    val id: String,
    val ratings: List<Int>
)