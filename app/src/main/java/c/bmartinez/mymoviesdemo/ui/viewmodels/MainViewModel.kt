package c.bmartinez.mymoviesdemo.ui.viewmodels

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import c.bmartinez.mymoviesdemo.data.MainRepository
import c.bmartinez.mymoviesdemo.data.Movies
import c.bmartinez.mymoviesdemo.network.RetrofitBuilderInstance
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainViewModel(val mainRepository: MainRepository) : ViewModel() {

//    suspend fun getMovieData(): MutableList<Movies>? {
//        return mainRepository.getMovies()
//    }
    
    var movieDataVM = liveData(Dispatchers.IO){
        val data = mainRepository.getMovies()
        emit(data)
    }

//    val savedMovies: MutableLiveData<MutableList<Movies>> = MutableLiveData()
//    private val parentJob = Job()
//    //create a coroutine context with the job and the dispatcher
//    private val coroutineContext: CoroutineContext
//        get() = parentJob + Dispatchers.Default
//    private val scope = CoroutineScope(coroutineContext)
//     //mainRepository = MainRepository(RetrofitBuilderInstance.movieApi)

//    fun fetchMovies(){
//        scope.launch {
//            val movies = mainRepository.getMovies()
//            savedMovies.postValue(movies)
//        }
//    }
//
//    fun cancelAllRequests() = coroutineContext.cancel()

//    fun getMovies() = liveData(Dispatchers.IO) {
//        savedMovies.value = mainRepository.getMovies()
//        emit(savedMovies)
//    }
}