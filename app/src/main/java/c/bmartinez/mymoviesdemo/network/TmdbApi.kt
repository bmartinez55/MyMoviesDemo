package c.bmartinez.mymoviesdemo.network

import c.bmartinez.mymoviesdemo.data.MovieDataResponse
import c.bmartinez.mymoviesdemo.data.Movies
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface TmdbApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(): MovieDataResponse
}