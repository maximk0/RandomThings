package com.example.myapplication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class MainViewModuleFactory @Inject constructor(
    private val mainViewModel: MainViewModel
    ) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return mainViewModel as T
        }
        throw IllegalArgumentException(ERROR_UNKNOWN_CLASS)
    }

    companion object {
        private const val ERROR_UNKNOWN_CLASS = "Unknown class name"
    }
}
