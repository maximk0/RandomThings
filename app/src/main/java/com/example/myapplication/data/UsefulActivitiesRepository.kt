package com.example.myapplication.data

import com.example.myapplication.entity.UsefulActivity
import javax.inject.Inject

class UsefulActivitiesRepository @Inject constructor(){

    suspend fun getUsefulActivity(): UsefulActivity =
        RetrofitInstance.searchRandomUserApi.getUsefulActivity()
}
