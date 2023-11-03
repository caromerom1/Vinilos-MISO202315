package com.miso2023equipo2.vinilos.viewmodels

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import com.miso2023equipo2.vinilos.data.uistate.NavigationUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update



class NavigationViewModel: ViewModel(){
    private val _uiState= MutableStateFlow(NavigationUiState(logged = false))
    val uiState: StateFlow<NavigationUiState> = _uiState.asStateFlow()
    init{
        _uiState.value=NavigationUiState(logged=false)
    }
    fun login(){
        _uiState.update{
            currentState->
            currentState.copy(logged=true)
        }
    }
    fun setIconMenu(icon:ImageVector?){
        _uiState.update{
            currentState->
            currentState.copy(icon=icon)
        }
    }


}