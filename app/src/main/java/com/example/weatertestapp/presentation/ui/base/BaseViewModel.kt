package com.example.weatertestapp.presentation.ui.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.ApiResult

open class BaseViewModel: ViewModel() {

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    protected fun <T> getDataByUseCase(result: ApiResult<T>): T? {
        return when (result) {
            is ApiResult.Error -> {
                try {
                    result.exception.localizedMessage?.let {
                        _error.postValue(it)
                    }
                    Log.e("Result: Error", result.exception.toString())
                } catch (e: Exception) {
                    Log.e("Result: Error", e.toString())
                }
                null
            }
            is ApiResult.Success -> {
                Log.i("Result: Success", "ReceivedData: ${result.data.toString()}")
                result.data
            }
        }
    }
}