package com.example.lifecyclefordatabinding

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lifecyclefordatabinding.util.isNotTypedYet

class MainActivityViewModel: ViewModel() {
    val visibleFirstName = MutableLiveData<Boolean>().apply { value = false }
    val firstName = MutableLiveData<String>()

    val visibleSpinner = MutableLiveData<Boolean>().apply { value = false }
    val spinner = MutableLiveData<String>()

    fun onNext() {
        visibleFirstName.value = firstName.value.toString().isNotTypedYet()

        MediatorLiveData<String>().apply {
            val first: (String?) -> Unit = first@{
                visibleFirstName.value = firstName.value.toString().isNotTypedYet()
            }
            addSource(firstName, first)

        }.also { it.observeForever{} }
    }

    fun onNextSpinner() {
        
    }
}