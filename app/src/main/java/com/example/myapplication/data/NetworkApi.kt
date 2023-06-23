package com.example.myapplication.data

import retrofit2.http.GET

fun interface SearchUsefulActivityApi{

    @GET("/api/activity")
    suspend fun getUsefulActivity(): UsefulActivityDto

}
