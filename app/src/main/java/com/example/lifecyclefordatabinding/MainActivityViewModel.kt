package com.example.lifecyclefordatabinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    val visibleFirstName = MutableLiveData<Boolean>().apply { value = false }
    val firstName = MutableLiveData<String>()

    fun onNext() {
        visibleFirstName.value = true
    }
}