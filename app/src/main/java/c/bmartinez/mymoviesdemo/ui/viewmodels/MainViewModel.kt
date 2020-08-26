package c.bmartinez.mymoviesdemo.ui.viewmodels

import androidx.lifecycle.*
import c.bmartinez.mymoviesdemo.data.MainRepository
import c.bmartinez.mymoviesdemo.data.Movies
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
//val mainRepository: MainRepository
class MainViewModel() : ViewModel() {
    private val mainRepository: MainRepository = MainRepository()
    
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