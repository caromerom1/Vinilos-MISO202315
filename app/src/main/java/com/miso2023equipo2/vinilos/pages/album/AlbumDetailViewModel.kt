package com.miso2023equipo2.vinilos.pages.album


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.miso2023equipo2.vinilos.App
import com.miso2023equipo2.vinilos.data.model.Album
import com.miso2023equipo2.vinilos.data.repository.AlbumsRepository
import com.miso2023equipo2.vinilos.navigation.state.DataUiState
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


class AlbumDetailViewModel(
    private val albumsRepository: AlbumsRepository
) : ViewModel() {
    var uiState: DataUiState<Album> by mutableStateOf(DataUiState.Loading)

    fun getAlbum(id: String) {
        viewModelScope.launch {
            uiState = try {
                val album = albumsRepository.getAlbum(id)
                DataUiState.Success(
                    album
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
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as App)
                val albumRepository = application.container.albumsRepository
                AlbumDetailViewModel(albumsRepository = albumRepository)
            }
        }
    }


}
