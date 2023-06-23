package com.example.myapplication.di

import com.example.myapplication.data.UsefulActivitiesRepository
import com.example.myapplication.presentation.MainViewModuleFactory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
 interface AppComponent {

    fun mainViewModelFactory(): MainViewModuleFactory

    fun apiRepository(): UsefulActivitiesRepository


}

