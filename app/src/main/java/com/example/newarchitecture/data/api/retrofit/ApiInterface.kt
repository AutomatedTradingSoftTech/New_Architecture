package com.example.newarchitecture.data.api.retrofit

import com.example.newarchitecture.data.model.Demo
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET
    fun getDemoAPI() : Call<Demo>
}