package c.bmartinez.mymoviesdemo.network

import c.bmartinez.mymoviesdemo.data.MovieData
import c.bmartinez.mymoviesdemo.data.MovieRatings
import c.bmartinez.mymoviesdemo.data.Movies
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("11911031e718")
    suspend fun getMoviesAsync(): Movies

    @GET("/")
    fun getMovieRatings(): List<MovieRatings>
}