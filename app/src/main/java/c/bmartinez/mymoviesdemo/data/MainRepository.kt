package c.bmartinez.mymoviesdemo.data

import c.bmartinez.mymoviesdemo.network.ApiService
import c.bmartinez.mymoviesdemo.network.RetrofitBuilderInstance

class MainRepository {
    var client: ApiService = RetrofitBuilderInstance.moviesApiService

    suspend fun getMovies() = client.getMovies()
}