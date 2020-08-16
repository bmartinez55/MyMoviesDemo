package c.bmartinez.mymoviesdemo.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import c.bmartinez.mymoviesdemo.data.MainRepository
import c.bmartinez.mymoviesdemo.utils.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class MainViewModel(private val mainRepository: MainRepository): ViewModel() {

    val getMovies = liveData(Dispatchers.IO) {
        val data  = mainRepository.getMovies()
        emit(data)
    }
}