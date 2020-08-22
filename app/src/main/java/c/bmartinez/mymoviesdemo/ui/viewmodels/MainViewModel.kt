package c.bmartinez.mymoviesdemo.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import c.bmartinez.mymoviesdemo.data.MainRepository
import c.bmartinez.mymoviesdemo.data.Movies
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainViewModel(private val mainRepository: MainRepository): ViewModel() {

    val savedMovies: MutableLiveData<MutableList<Movies>> = MutableLiveData()
    private val parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)

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