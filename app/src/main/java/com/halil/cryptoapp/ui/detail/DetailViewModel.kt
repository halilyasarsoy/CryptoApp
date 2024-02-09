package com.halil.cryptoapp.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.halil.cryptoapp.model.detail.DetailResponse
import com.halil.cryptoapp.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: DetailRepository,
) : ViewModel() {

     val detailResponse: MutableLiveData<DetailResponse?> = MutableLiveData()
     val isLoading: MutableLiveData<Boolean> = MutableLiveData(true)
     val onError: MutableLiveData<String?> = MutableLiveData()

    fun getDetail(
        apiKey: String, symbol: String
    ) = viewModelScope.launch {
        isLoading.value = true
        val request = repository.getDetail(apiKey, symbol)
        when (request) {
            is NetworkResult.Success -> {
                isLoading.value = false
                detailResponse.value=request.data
            }

            is NetworkResult.Error -> {
                isLoading.value=false
                onError.value = request.message
            }
        }
    }
}