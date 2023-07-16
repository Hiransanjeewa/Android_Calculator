package com.sanjeewabasnayaka.android.androidcalculator.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var result = MutableLiveData<Double>()

    fun add(number1: Double,number2: Double){
        var result = number1.plus(number2)
    }
}