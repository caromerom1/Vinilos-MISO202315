package com.miso2023equipo2.vinilos.data.uistate

sealed interface AlbumCatalogueUiState {
    data class Success(val albums: String) : AlbumCatalogueUiState
    object Error : AlbumCatalogueUiState
    object Loading : AlbumCatalogueUiState
}