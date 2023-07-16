package com.sanjeewabasnayaka.android.androidcalculator.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var result = MutableLiveData<Double>(0.0) // Two type of data (mutable and immutable data)
    // mutable - value of result is going to change over the time
    // So many implementations (rx java - has lot of operators)
    // Checkout more alternatives for observables
    // Stream ? synchronous/ asynchronous
    fun addition(number1: Double,number2: Double){
        result.value = number1.plus(number2)
        println(result);
        Log.d("Result of addition-->", result.toString())
    }
    fun subtraction(number1: Double,number2: Double){
        result.value = number1.minus(number2)
        println(result);
        Log.d("Result of subtraction-->", result.toString())
    }
    fun multiplication(number1: Double,number2: Double){
        result.value = number1.div(number2)
        println(result);
        Log.d("Result of multiplication-->", result.toString())
    }
    fun division(number1: Double,number2: Double){
        result.value = number1.div(number2)
        println(result);
        Log.d("Result of division-->", result.toString())
    }
}