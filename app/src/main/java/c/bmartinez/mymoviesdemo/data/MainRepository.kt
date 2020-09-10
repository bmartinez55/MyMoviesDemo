package c.bmartinez.mymoviesdemo.data

import c.bmartinez.mymoviesdemo.network.TmdbApi
import c.bmartinez.mymoviesdemo.network.RetrofitBuilderInstance

class MainRepository(): BaseRepository() {
    var client: TmdbApi = RetrofitBuilderInstance.movieApi
    fun getMovies() = client.getMoviesAsync()
}