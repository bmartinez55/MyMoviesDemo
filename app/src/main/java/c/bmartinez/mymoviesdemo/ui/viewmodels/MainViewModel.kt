package c.bmartinez.mymoviesdemo.ui.viewmodels

import androidx.lifecycle.*
import c.bmartinez.mymoviesdemo.data.MainRepository
import c.bmartinez.mymoviesdemo.data.Movies
import c.bmartinez.mymoviesdemo.network.RetrofitBuilderInstance
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainViewModel: ViewModel() {

    private val parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)
    private val respository: MainRepository = MainRepository(RetrofitBuilderInstance.tmdbApi)
    val popularMoviesLiveData = MutableLiveData<MutableList<Movies>>()

    fun fetchMovies(){
        scope.launch{
            val popularMovies = respository.getPopularMovies()
            popularMoviesLiveData.postValue(popularMovies)
        }
    }

    fun cancelAllRequests() = coroutineContext.cancel()
}