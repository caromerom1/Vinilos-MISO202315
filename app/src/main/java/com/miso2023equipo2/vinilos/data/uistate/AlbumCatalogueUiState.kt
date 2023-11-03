package com.miso2023equipo2.vinilos.data.uistate

import com.miso2023equipo2.vinilos.model.Album

sealed interface AlbumCatalogueUiState {
    data class Success(val albums: List<Album>) : AlbumCatalogueUiState
    object Error : AlbumCatalogueUiState
    object Loading : AlbumCatalogueUiState
}