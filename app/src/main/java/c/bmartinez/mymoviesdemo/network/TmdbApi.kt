package c.bmartinez.mymoviesdemo.network

import c.bmartinez.mymoviesdemo.data.MovieDataResponse
import c.bmartinez.mymoviesdemo.data.MovieGenreResponse
import retrofit2.http.GET

interface TmdbApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(): MovieDataResponse

    @GET("genre/movie/list")
    suspend fun getMovieGenres(): MovieGenreResponse
}