package com.miso2023equipo2.vinilos.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.miso2023equipo2.vinilos.R
import com.miso2023equipo2.vinilos.navigation.state.DataUiState

@Composable
fun DataFetchStates(uiState: DataUiState<*>, @StringRes errorMessage: Int, renderOnSuccess: @Composable () -> Unit) {

    when (uiState) {
        is DataUiState.Loading -> LoadingScreen(
            R.string.loading,
            modifier = Modifier.fillMaxSize()
        )

        is DataUiState.Success -> {
            renderOnSuccess()
        }

        is DataUiState.Error -> ErrorScreen(
            errorMessage,
            modifier = Modifier.fillMaxSize()
        )
    }
}