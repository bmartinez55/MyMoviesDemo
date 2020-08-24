package c.bmartinez.mymoviesdemo.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

object RetrofitBuilderInstance {
    private const val MOVIES_URL = "https://json.extendsclass.com/bin/"
    private val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
    private val client: OkHttpClient = OkHttpClient().newBuilder().addInterceptor(logging).build()

    private fun getMoviesRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(MOVIES_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }


    val movieApi: ApiService = getMoviesRetrofit().create(ApiService::class.java)
}
//
//Creating a Network Interceptor to add api_key in all the request as authInterceptor
//    private val interceptor = Interceptor {chain ->
//        val url = chain.request().url.newBuilder().build()
//        val request = chain.request().newBuilder().url(url).build()
//        chain.proceed(request)
//    }
//
//    //Creating a networking client to using OkHttp and add our authInterceptor
//    private val apiClient = OkHttpClient().newBuilder().addInterceptor(interceptor).build()
