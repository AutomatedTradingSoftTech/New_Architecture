package com.example.newarchitecture.di

import com.example.newarchitecture.views.activity.MainActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, ApiModule::class])
interface AppComponent {
    fun inject(activity: MainActivity?)
}