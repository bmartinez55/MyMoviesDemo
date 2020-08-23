package c.bmartinez.mymoviesdemo.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import c.bmartinez.mymoviesdemo.data.MainRepository
import c.bmartinez.mymoviesdemo.data.Movies
import c.bmartinez.mymoviesdemo.network.RetrofitBuilderInstance
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainViewModel() : ViewModel() {

    val savedMovies: MutableLiveData<MutableList<Movies>> = MutableLiveData()
    private val parentJob = Job()
    //create a coroutine context with the job and the dispatcher
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)
    private val mainRepository: MainRepository = MainRepository(RetrofitBuilderInstance.movieApi)

    fun fetchMovies(){
        scope.launch {
            val movies = mainRepository.getMovies()
            savedMovies.postValue(movies)
        }
    }

    fun cancelAllRequests() = coroutineContext.cancel()

//    fun getMovies() = liveData(Dispatchers.IO) {
//        savedMovies.value = mainRepository.getMovies()
//        emit(savedMovies)
//    }
}