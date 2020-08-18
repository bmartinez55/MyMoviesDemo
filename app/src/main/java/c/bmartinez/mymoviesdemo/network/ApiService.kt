package c.bmartinez.mymoviesdemo.network

import c.bmartinez.mymoviesdemo.data.MovieRatings
import c.bmartinez.mymoviesdemo.data.Movies
import retrofit2.http.GET
import java.util.*

interface ApiService {
    @GET("/")
    suspend fun getMovies(): List<Movies>

    @GET("/")
    suspend fun getMovieRatings(): List<MovieRatings>
}