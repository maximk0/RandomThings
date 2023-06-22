package com.example.myapplication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.UsefulActivitiesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val apiRepository: UsefulActivitiesRepository
) : ViewModel() {

    private val _randomThings = MutableStateFlow("")
    val randomThings = _randomThings.asStateFlow()


    init {
        reloadUsefulActivity()
    }

    fun reloadUsefulActivity() {
        viewModelScope.launch {
            _randomThings.value = apiRepository.getUsefulActivity().activity
        }
    }

}
