package com.example.newarchitecture.di

import android.app.Application
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
internal class AppModule(private val mApplication: Application) {
    @Provides
    @Singleton
    fun provideApplication(): Application {
        return mApplication
    }
}