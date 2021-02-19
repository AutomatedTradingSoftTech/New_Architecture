package com.example.newarchitecture.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newarchitecture.data.model.Demo
import com.example.newarchitecture.data.repository.DemoRepository
import java.util.*

class DemoViewModel : ViewModel() {

    var demoData : MutableLiveData<Demo>? = null

    fun getDemoData() : LiveData<Demo>? {
        demoData = DemoRepository.getDemoApiCall()
        return demoData
    }

}