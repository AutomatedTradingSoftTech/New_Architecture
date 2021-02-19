package com.example.newarchitecture

import android.app.Application
import com.example.newarchitecture.di.ApiModule
import com.example.newarchitecture.di.AppComponent
import com.example.newarchitecture.di.AppModule
import com.example.newarchitecture.di.DaggerAppComponent

class MyApplication : Application() {
    private var mApiComponent: AppComponent? = null
    override fun onCreate() {
        super.onCreate()
        mApiComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .apiModule(ApiModule("https://simplifiedcoding.net/demos/"))
            .build()
    }

    val netComponent: AppComponent?
        get() = mApiComponent
}