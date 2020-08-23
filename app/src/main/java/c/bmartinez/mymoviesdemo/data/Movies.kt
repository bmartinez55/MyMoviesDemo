package c.bmartinez.mymoviesdemo.data

data class MovieData(
    val movies: List<Movies>
)

data class Movies(
    val id: String,
    val title: String,
    val year: String,
    val genres: List<String>,
    val duration: String,
    val releasedata: String,
    val storyline: String,
    val actors: List<String>,
    val posterurl: String,
    val ratings: List<MovieRatings>
)

data class MovieRatings(
    val id: String,
    val ratings: List<Int>
)