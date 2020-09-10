package c.bmartinez.mymoviesdemo.network

import c.bmartinez.mymoviesdemo.data.MovieDataResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface TmdbApi {

    @GET("movie/popular")
    suspend fun getMoviesAsync(): Deferred<Response<MovieDataResponse>>
}