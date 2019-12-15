package com.example.lifecyclefordatabinding

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableInt
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lifecyclefordatabinding.util.isNotTypedYet


class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    val visibleFirstName = MutableLiveData<Boolean>().apply { value = false }
    val firstName = MutableLiveData<String>()

    val visibleSpinner = MutableLiveData<Boolean>().apply { value = false }
    val selectedDay = MutableLiveData<Int>()

    fun onNext() {
        var isAllValid = true
        visibleFirstName.value = firstName.value.toString().isNotTypedYet()

        MediatorLiveData<String>().apply {
            val first: (String?) -> Unit = first@{
                visibleFirstName.value = firstName.value.toString().isNotTypedYet()
                isAllValid = !visibleFirstName.value!!
            }
            val spinner: (Int?) -> Unit = spinner@{
                visibleSpinner.value = selectedDay.value == 0
                isAllValid = !visibleSpinner.value!!
            }


            addSource(firstName, first)
            addSource(selectedDay, spinner)

        }.also { it.observeForever{} }

        if(isAllValid) {
            val strArray = getApplication<Application>().resources.getStringArray(R.array.days)
            Log.d("tttt", ">> values >" +firstName.value.toString() + " >>"+strArray[selectedDay.value!!])
        }
    }
}