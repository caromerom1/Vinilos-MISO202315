package com.miso2023equipo2.vinilos.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import com.miso2023equipo2.vinilos.navigation.state.NavigationUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class NavigationViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(NavigationUiState(logged = false))
    val uiState: StateFlow<NavigationUiState> = _uiState.asStateFlow()

    fun setIconMenu(icon: ImageVector?) {
        _uiState.update { currentState ->
            currentState.copy(icon = icon)
        }
    }


}