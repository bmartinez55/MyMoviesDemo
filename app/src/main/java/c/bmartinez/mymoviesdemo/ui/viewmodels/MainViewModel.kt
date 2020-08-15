package c.bmartinez.mymoviesdemo.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import c.bmartinez.mymoviesdemo.data.MainRepository
import kotlinx.coroutines.Dispatchers

class MainViewModel: ViewModel() {
    val repository: MainRepository = MainRepository()

    val getMovies = liveData(Dispatchers.IO){
        val movieData = repository.getMovies()

        emit(movieData)
    }
}