package c.bmartinez.mymoviesdemo.data

import c.bmartinez.mymoviesdemo.network.ApiService
import c.bmartinez.mymoviesdemo.network.RetrofitBuilderInstance

class MainRepository(private val api: ApiService): BaseRepository() {
    var client: ApiService = RetrofitBuilderInstance.movieApi
    suspend fun getMovies() = client.getMoviesAsync()
}