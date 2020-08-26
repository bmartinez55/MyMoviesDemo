package c.bmartinez.mymoviesdemo.data

import c.bmartinez.mymoviesdemo.network.ApiService
import c.bmartinez.mymoviesdemo.network.RetrofitBuilderInstance

class MainRepository(): BaseRepository() {
    var client: ApiService = RetrofitBuilderInstance.movieApi
    fun getMovies() = client.getMoviesAsync()
}