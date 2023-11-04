package com.miso2023equipo2.vinilos.pages.album


import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miso2023equipo2.vinilos.data.repository.AlbumsRepositoryImpl
import com.miso2023equipo2.vinilos.navigation.state.AlbumCatalogueUiState
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


class AlbumCatalogueViewModel : ViewModel() {
    var uiState: AlbumCatalogueUiState by mutableStateOf(AlbumCatalogueUiState.Loading)

    init {
        getAlbums()
    }

    private fun getAlbums() {
        viewModelScope.launch {
            uiState = try {
                val albumsRepository = AlbumsRepositoryImpl()
                val listResult = albumsRepository.getAlbums()
                AlbumCatalogueUiState.Success(
                    listResult
                )
            } catch (e: IOException) {
                Log.d("ERROR_TAG", "Mensaje de error", e)
                AlbumCatalogueUiState.Error
            } catch (e: HttpException) {
                Log.d("ERROR_TAG", "Mensaje de error", e)
                AlbumCatalogueUiState.Error
            }
        }
    }
}