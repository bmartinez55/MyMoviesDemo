package c.bmartinez.mymoviesdemo.data

import android.util.Log
import c.bmartinez.mymoviesdemo.utils.Result
import retrofit2.Response
import java.io.IOException

@Suppress("UNCHECKED_CAST")
open class BaseRepository {
    suspend fun <T: Any> safeApiCall(call: suspend() -> Response<T>, errorMessage: String): T? {
        val result: Result<T> = safeApiCall(call,errorMessage) as Result<T>
        var data: T? = null

        when(result){
            is Result.Success ->
                data = result.data
            is Result.Error ->
                Log.d("1.DataRepository", "$errorMessage & Exception - ${result.exception}")
        }
        return data
    }

    private suspend fun <T: Any> safeApiResult(call: suspend() -> Response<T>, errorMessage: String): Result<T>{
        val response = call.invoke()
        if(response.isSuccessful) return Result.Success(response.body()!!)
        return Result.Error(IOException("Error Occured during getting safe Api result, Custom ERROR - $errorMessage"))
    }
}