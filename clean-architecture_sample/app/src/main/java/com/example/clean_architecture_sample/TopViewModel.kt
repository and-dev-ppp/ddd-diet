package com.example.clean_architecture_sample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.usecase.FatUseCase

class TopViewModel(private val useCase: FatUseCase) : ViewModel(){

    val fat = MutableLiveData("けんはデブ")

}