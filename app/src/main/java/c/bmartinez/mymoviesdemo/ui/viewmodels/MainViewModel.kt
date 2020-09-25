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
    val popularMoviesLiveData = MutableLiveData<List<Movies>>()
        //MutableLiveData<MutableList<Movies>>()
    //MutableList<Movies>
    fun fetchMovies(): LiveData<List<Movies>>{
        scope.launch{
            val popularMovies = respository.getPopularMovies()
            popularMoviesLiveData.postValue(popularMovies)
        }
            return popularMoviesLiveData
    }

    fun cancelAllRequests() = coroutineContext.cancel()
}