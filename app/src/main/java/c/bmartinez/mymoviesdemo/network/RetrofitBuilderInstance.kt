package c.bmartinez.mymoviesdemo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitBuilderInstance {

    private const val MOVIES_URL = "https://api.jsonbin.io/"

    private fun getMoviesRetrofit(): Retrofit{
        return Retrofit.Builder().baseUrl(MOVIES_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    val apiService: ApiService = getMoviesRetrofit().create()
}