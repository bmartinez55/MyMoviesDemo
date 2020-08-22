package c.bmartinez.mymoviesdemo.data

import c.bmartinez.mymoviesdemo.network.ApiHelper
import c.bmartinez.mymoviesdemo.network.ApiService

class MainRepository(private val api: ApiService): BaseRepository() {
    suspend fun getMovies(): MutableList<Movies>?{
        val movieResponse = safeApiCall(
            call = {api.getMovies().await()},
            errorMessage = "Error Fetching Movies"
        )
        return movieResponse?.results?.toMutableList()
    }

    //suspend fun getMovies() = apiHelper.getMovies()
}