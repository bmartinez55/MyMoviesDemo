package c.bmartinez.mymoviesdemo.network

class ApiHelper(private val apiService: ApiService) {
    suspend fun getMovies() = apiService.getMovies()
}