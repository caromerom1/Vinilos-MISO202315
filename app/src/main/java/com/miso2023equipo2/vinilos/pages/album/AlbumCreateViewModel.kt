package com.miso2023equipo2.vinilos.pages.album

import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavController
import com.miso2023equipo2.vinilos.VinylosApplication
import com.miso2023equipo2.vinilos.data.model.Album
import com.miso2023equipo2.vinilos.data.model.AlbumCreate
import com.miso2023equipo2.vinilos.data.repository.AlbumsRepository
import com.miso2023equipo2.vinilos.navigation.state.DataUiState
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class AlbumCreateViewModel(
    private val albumsRepository: AlbumsRepository
) : ViewModel() {
    var uiState: DataUiState<Album> by mutableStateOf(DataUiState.Loading)


    fun createAlbum(album: AlbumCreate, navController: NavController) {
        viewModelScope.launch {
            uiState = try {
                val createResult = albumsRepository.createAlbum(album)

                Toast.makeText(
                    navController.context,
                    "Álbum creado",
                    Toast.LENGTH_SHORT
                ).show()
                DataUiState.Success(
                    createResult
                )
            } catch (e: IOException) {
                Toast.makeText(
                    navController.context,
                    "Error al crear el álbum",
                    Toast.LENGTH_SHORT
                ).show()
                DataUiState.Error
            } catch (e: HttpException) {
                Toast.makeText(
                    navController.context,
                    "Error al crear el álbum",
                    Toast.LENGTH_SHORT
                ).show()
                DataUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as VinylosApplication)
                val albumRepository = application.container.albumsRepository
                AlbumCreateViewModel(albumsRepository = albumRepository)
            }
        }
    }
}