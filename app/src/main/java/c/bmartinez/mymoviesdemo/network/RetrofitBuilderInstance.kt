package c.bmartinez.mymoviesdemo.network

import c.bmartinez.mymoviesdemo.BuildConfig
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
    private const val MOVIES_URL = "https://api.themoviedb.org/3/movie/157336?api_key={api_key}"
    private const val tmdbApiKey = BuildConfig.
    //Creating Auth Interceptor to add api_key query infront of all requests
    private val authInterceptor = Interceptor { chain ->
        val newUrl = chain.request().url
            .newBuilder()
            .addQueryParameter("api_key",)
    }


}
