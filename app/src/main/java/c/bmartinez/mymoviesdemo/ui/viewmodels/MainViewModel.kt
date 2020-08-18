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
}