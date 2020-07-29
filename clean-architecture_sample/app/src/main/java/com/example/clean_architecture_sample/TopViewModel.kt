package com.example.clean_architecture_sample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.FatUseCase
import kotlinx.coroutines.launch
import timber.log.Timber

class TopViewModel(private val useCase: FatUseCase) : ViewModel() {

    val fat = MutableLiveData("けんはデブ")

    init {
        Timber.d("前")
        viewModelScope.launch {
            useCase.insert(75F)
        }
        Timber.d("後")
    }

//    private suspend fun test() {
//        withContext(Dispatchers.IO) {
//            useCase.insert(75F)
//        }
//    }

}