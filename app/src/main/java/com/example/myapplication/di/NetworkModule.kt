package com.example.myapplication.di

import com.example.myapplication.data.SearchUsefulActivityApi
import com.example.myapplication.data.UsefulActivitiesRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): SearchUsefulActivityApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(SearchUsefulActivityApi::class.java)

    @Singleton
    @Provides
    fun provideApiRepository(api: SearchUsefulActivityApi): UsefulActivitiesRepository =
        UsefulActivitiesRepository(api)

    companion object {
        private const val BASE_URL = "https://www.boredapi.com"
    }
}
