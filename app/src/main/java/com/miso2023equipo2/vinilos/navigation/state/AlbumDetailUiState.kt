package com.miso2023equipo2.vinilos.navigation.state

import com.miso2023equipo2.vinilos.data.model.Album

sealed interface AlbumDetailUiState {
    data class Success(val album: Album) : AlbumDetailUiState
    object Error : AlbumDetailUiState
    object Loading : AlbumDetailUiState
}