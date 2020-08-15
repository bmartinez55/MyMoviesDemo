package c.bmartinez.mymoviesdemo.data

import com.google.gson.annotations.SerializedName

data class MovieRatings(
    @SerializedName("id")
    val it: String,
    @SerializedName("ratings")
    val ratings: List<Int>
)