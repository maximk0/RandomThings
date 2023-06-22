package com.example.myapplication.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL="https://www.boredapi.com"

object RetrofitInstance{
    private val retrofit= Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val searchRandomUserApi:SearchUsefulActivityApi =
        retrofit.create(SearchUsefulActivityApi::class.java)

}


fun interface SearchUsefulActivityApi{

    @GET("/api/activity")
    suspend fun getUsefulActivity(): UsefulActivityDto

}
