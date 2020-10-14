package c.bmartinez.mymoviesdemo.ui.viewmodels

import androidx.lifecycle.*
import c.bmartinez.mymoviesdemo.data.MainRepository
import c.bmartinez.mymoviesdemo.data.MovieDataResponse
import c.bmartinez.mymoviesdemo.data.MovieGenreResponse
import c.bmartinez.mymoviesdemo.network.RetrofitBuilderInstance
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainViewModel: ViewModel() {

    private val parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)
    private val repository: MainRepository = MainRepository(RetrofitBuilderInstance.tmdbApi)
    private val popularMoviesLiveData = MutableLiveData<MovieDataResponse>()
    private val movieGenresLiveData = MutableLiveData<MovieGenreResponse>()

    fun fetchMovies(): LiveData<MovieDataResponse>{
        scope.launch{
            val popularMovies = repository.getPopularMovies()
            popularMoviesLiveData.postValue(popularMovies)
        }
            return popularMoviesLiveData
    }

    fun fetchMovieGenres(): LiveData<MovieGenreResponse>{
        scope.launch {
            val movieGenres = repository.getMovieGenres()
            movieGenresLiveData.postValue(movieGenres)
        }
        return movieGenresLiveData
    }

    fun cancelAllRequests() = coroutineContext.cancel()
}