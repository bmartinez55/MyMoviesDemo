package c.bmartinez.mymoviesdemo.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

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
    val releaseData: String,
    @SerializedName("storyline")
    val storyLine: String,
    @SerializedName("actors")
    val actors: List<String>,
    @SerializedName("posterurl")
    val posterUrl: String
): Serializable