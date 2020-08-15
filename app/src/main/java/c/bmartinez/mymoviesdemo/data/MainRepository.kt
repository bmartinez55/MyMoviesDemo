package c.bmartinez.mymoviesdemo.data

import c.bmartinez.mymoviesdemo.network.ApiHelper
import c.bmartinez.mymoviesdemo.network.ApiService
import c.bmartinez.mymoviesdemo.network.RetrofitBuilderInstance

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getMovies() = apiHelper.getMovies()
}