package c.bmartinez.mymoviesdemo.data

import c.bmartinez.mymoviesdemo.network.TmdbApi
//: BaseRepository()
class MainRepository(private val api: TmdbApi) {
    suspend fun getPopularMovies(): List<Movies> {
        return api.getPopularMovies()
//        //safeApiCall is defined in BasedRepository
//        val movieDataResponse = safeApiCall(
//            call = {api.getPopularMovies()},
//            errorMessage = "Error Fetching Popular Movies"
//        )
        //return movieDataResponse.movies.toMutableList()
    }
}