package c.bmartinez.mymoviesdemo.network

import c.bmartinez.mymoviesdemo.data.Movies
import retrofit2.http.GET

interface ApiService {
    @GET("/b/5f2c4877dddf413f95be718b")
    suspend fun getMovies(): List<Movies>
}