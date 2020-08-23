package c.bmartinez.mymoviesdemo.data

import c.bmartinez.mymoviesdemo.network.ApiService

class MainRepository(private val api: ApiService): BaseRepository() {
    //get movie data using safe api call
    suspend fun getMovies(): MutableList<Movies>?{
        return safeApiCall(
            //await the result of deferred type
            call = { api.getMoviesAsync().await() },
            errorMessage = "Error fetching movie data"
            //Convert to mutable list
        )?.movies?.toMutableList()
    }

    //suspend fun getMovies() = apiHelper.getMovies()
}