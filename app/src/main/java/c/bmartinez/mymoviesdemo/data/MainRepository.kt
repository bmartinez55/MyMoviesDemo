package c.bmartinez.mymoviesdemo.data

import c.bmartinez.mymoviesdemo.network.TmdbApi

class MainRepository(private val api: TmdbApi) {

    suspend fun getPopularMovies(): MovieDataResponse = api.getPopularMovies()
    suspend fun getMovieGenres(): MovieGenreResponse = api.getMovieGenres()

}