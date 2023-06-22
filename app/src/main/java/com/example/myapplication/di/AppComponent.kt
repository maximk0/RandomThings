package com.example.myapplication.di

import com.example.myapplication.presentation.MainViewModuleFactory
import dagger.Component

@Component
fun interface AppComponent {

    fun mainViewModelFactory(): MainViewModuleFactory

}
