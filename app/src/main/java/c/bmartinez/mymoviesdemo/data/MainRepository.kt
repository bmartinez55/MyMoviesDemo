package c.bmartinez.mymoviesdemo.data

import c.bmartinez.mymoviesdemo.network.TmdbApi
import c.bmartinez.mymoviesdemo.network.RetrofitBuilderInstance

class MainRepository(private val api: TmdbApi): BaseRepository() {
    suspend fun getPopularMovies(): MutableList<Movies>? {

        //safeApiCall is defined in BasedRepository
        val movieDataResponse = safeApiCall(
            call = {api.getPopularMovies().await()},
            errorMessage = "Error Fetching Popular Movies"
        )
        return movieDataResponse?.movies?.toMutableList()
    }
}