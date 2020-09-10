package c.bmartinez.mymoviesdemo.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import c.bmartinez.mymoviesdemo.data.MovieRatings
import c.bmartinez.mymoviesdemo.data.Movies
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface TmdbApi {

    //@Headers("user-key: 1c976c5d-e5b0-11ea-b386-0242ac110002")
    @GET("/")
    fun getMoviesAsync(): List<Movies>

    @GET("/")
    fun getMovieRatings(): List<MovieRatings>
}