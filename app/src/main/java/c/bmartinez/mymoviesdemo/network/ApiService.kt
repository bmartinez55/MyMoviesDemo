package c.bmartinez.mymoviesdemo.network

import c.bmartinez.mymoviesdemo.data.MovieData
import c.bmartinez.mymoviesdemo.data.MovieRatings
import c.bmartinez.mymoviesdemo.data.Movies
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/b/5f417248514ec5112d0c1110/1")
    fun getMovies(): Deferred<Response<MovieData>>

    @GET("/")
    fun getMovieRatings(): List<MovieRatings>
}