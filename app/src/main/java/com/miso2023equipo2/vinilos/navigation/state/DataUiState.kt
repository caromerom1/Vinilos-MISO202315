package com.miso2023equipo2.vinilos.navigation.state

sealed interface DataUiState<in T> {
    data class Success<T>(val data: T) : DataUiState<T>
    object Error : DataUiState<Any>
    object Loading : DataUiState<Any>
}