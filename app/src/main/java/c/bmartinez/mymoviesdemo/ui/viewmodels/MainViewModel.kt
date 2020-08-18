package c.bmartinez.mymoviesdemo.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import c.bmartinez.mymoviesdemo.data.MainRepository
import c.bmartinez.mymoviesdemo.data.Movies
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val mainRepository: MainRepository): ViewModel() {

    val savedMovies: MutableLiveData<List<Movies>> = MutableLiveData()

    fun getMovies() = liveData(Dispatchers.IO) {
        savedMovies.value = mainRepository.getMovies()
        emit(savedMovies)
    }

//    private var movieList: MutableLiveData<List<Movies>> = MutableLiveData()
//    val savedMovieList: MutableList<Movies> = mutableListOf()
//
//    suspend fun getMovies(): LiveData<List<Movies>> {
//        mainRepository.getMovies().forEach {
//            if(it != null){
//                Log.d("READ DATA", "Call failed to read snapshop")
//                movieList.value = null
//                return@forEach
//            }
//            savedMovieList.add(it)
//        }
//        movieList.value = savedMovieList
////        val data  = mainRepository.getMovies()
////        emit(movieList)
//        return movieList
    //}
}