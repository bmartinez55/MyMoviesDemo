package c.bmartinez.mymoviesdemo.network

import c.bmartinez.mymoviesdemo.data.MovieRatings
import c.bmartinez.mymoviesdemo.data.Movies
import retrofit2.http.GET
import java.util.*

interface ApiService {
    @GET("/b/5f2c4877dddf413f95be718b")
    suspend fun getMovies(): List<Movies>

    @GET("/b/5f2c4951dddf413f95be721c")
    suspend fun getMovieRatings(): List<MovieRatings>
}