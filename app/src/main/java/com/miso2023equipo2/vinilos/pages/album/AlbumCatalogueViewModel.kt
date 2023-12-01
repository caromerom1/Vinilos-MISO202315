package com.miso2023equipo2.vinilos.pages.album


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.miso2023equipo2.vinilos.VinylosApplication
import com.miso2023equipo2.vinilos.data.model.Album
import com.miso2023equipo2.vinilos.data.repository.AlbumsRepository
import com.miso2023equipo2.vinilos.navigation.state.DataUiState
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


class AlbumCatalogueViewModel(
    private val albumsRepository: AlbumsRepository
) : ViewModel() {
    var uiState: DataUiState<List<Album>> by mutableStateOf(DataUiState.Loading)

    init {
        getAlbums()
    }

    private fun getAlbums() {
        viewModelScope.launch {
            uiState = try {
                val listResult = albumsRepository.getAlbums()
                DataUiState.Success(
                    listResult
                )
            } catch (e: IOException) {
                DataUiState.Error
            } catch (e: HttpException) {
                DataUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as VinylosApplication)
                val albumRepository = application.container.albumsRepository
                AlbumCatalogueViewModel(albumsRepository = albumRepository)
            }
        }
    }
}