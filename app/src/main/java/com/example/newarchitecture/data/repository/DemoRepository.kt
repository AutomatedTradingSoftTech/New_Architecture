package com.example.newarchitecture.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.newarchitecture.data.api.retrofit.RetrofitClient
import com.example.newarchitecture.data.model.Demo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object DemoRepository {

    val demoData = MutableLiveData<Demo>()

    fun getDemoApiCall() : MutableLiveData<Demo>{
        val call = RetrofitClient.apiInterface.getDemoAPI()
        call.enqueue(object : Callback<Demo>{
            override fun onResponse(call: Call<Demo>, response: Response<Demo>) {
                demoData.value = response.body()
            }

            override fun onFailure(call: Call<Demo>, t: Throwable) {
                demoData.value = null
            }

        })

        return demoData
    }
}