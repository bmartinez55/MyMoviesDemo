package c.bmartinez.mymoviesdemo.network

import c.bmartinez.mymoviesdemo.data.MovieRatings
import c.bmartinez.mymoviesdemo.data.MovieResponse
import c.bmartinez.mymoviesdemo.data.Movies
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
//    @GET("b/5f2c4877dddf413f95be718b")
//    suspend fun getMovies(): List<Movies>
    @GET("/b/5f417248514ec5112d0c1110/1")
    suspend fun getMovies(): Deferred<Response<MovieResponse>>

    @GET("/")
    suspend fun getMovieRatings(): List<MovieRatings>
}