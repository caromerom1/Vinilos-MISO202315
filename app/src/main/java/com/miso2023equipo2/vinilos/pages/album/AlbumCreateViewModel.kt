package com.miso2023equipo2.vinilos.pages.album

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.MutableState
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
import com.miso2023equipo2.vinilos.R
import com.miso2023equipo2.vinilos.Strings
import com.miso2023equipo2.vinilos.App
import com.miso2023equipo2.vinilos.data.model.Album
import com.miso2023equipo2.vinilos.data.model.AlbumCreate
import com.miso2023equipo2.vinilos.data.repository.AlbumsRepository
import com.miso2023equipo2.vinilos.navigation.state.DataUiState
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

data class AlbumCreatePageState(
    val name: MutableState<String>,
    val description: MutableState<String>,
    val date: MutableState<String>,
    val genre: MutableState<String>,
    val cover: MutableState<String>,
)

class AlbumCreateViewModel(
    private val albumsRepository: AlbumsRepository
) : ViewModel() {
    var uiState: DataUiState<Album> by mutableStateOf(DataUiState.Loading)

    var formState: AlbumCreatePageState by mutableStateOf(
        AlbumCreatePageState(
            name = mutableStateOf(""),
            description = mutableStateOf(""),
            date = mutableStateOf(""),
            genre = mutableStateOf(""),
            cover = mutableStateOf(""),
        )
    )

    fun createAlbum(navController: NavController) {
        viewModelScope.launch {
            uiState = try {
                val album = AlbumCreate(
                    name = formState.name.value,
                    description = formState.description.value,
                    releaseDate = formState.date.value,
                    genre = formState.genre.value,
                    cover = formState.cover.value,
                    recordLabel = "Sony Music"
                )
                val createResult = albumsRepository.createAlbum(album)

                Toast.makeText(
                    navController.context,
                    Strings.get(R.string.album_created_toast),
                    Toast.LENGTH_SHORT
                ).show()
                DataUiState.Success(
                    createResult
                )
            } catch (e: IOException) {
                Toast.makeText(
                    navController.context,
                    Strings.get(R.string.album_creation_failed_toast),
                    Toast.LENGTH_SHORT
                ).show()
                DataUiState.Error
            } catch (e: HttpException) {
                Toast.makeText(
                    navController.context,
                    Strings.get(R.string.album_creation_failed_toast),
                    Toast.LENGTH_SHORT
                ).show()
                DataUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as App)
                val albumRepository = application.container.albumsRepository
                AlbumCreateViewModel(albumsRepository = albumRepository)
            }
        }
    }
}