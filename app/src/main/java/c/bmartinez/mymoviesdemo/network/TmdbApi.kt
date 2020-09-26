package c.bmartinez.mymoviesdemo.network

import c.bmartinez.mymoviesdemo.data.MovieDataResponse
import retrofit2.http.GET

interface TmdbApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(): MovieDataResponse
}