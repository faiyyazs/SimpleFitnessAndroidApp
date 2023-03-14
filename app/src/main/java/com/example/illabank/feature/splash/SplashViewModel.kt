package com.example.illabank.feature.splash

import androidx.lifecycle.viewModelScope
import com.example.illabank.feature.base.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch


class SplashViewModel() : BaseViewModel() {

    private val _navigationFlow: MutableStateFlow<Boolean> = MutableStateFlow(false)

    val navigationFlow: StateFlow<Boolean> = _navigationFlow

    init {
        viewModelScope.launch {
            flow<Boolean> {
                delay(2000L)
                emit(true)
            }.collect {
                _navigationFlow.value = true
            }
        }
    }

}