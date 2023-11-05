package com.miso2023equipo2.vinilos.pages.album


import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miso2023equipo2.vinilos.data.model.Album
import com.miso2023equipo2.vinilos.data.repository.AlbumsRepositoryImpl
import com.miso2023equipo2.vinilos.navigation.state.DataUiState
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


class AlbumDetailViewModel : ViewModel() {
    var uiState: DataUiState<Album> by mutableStateOf(DataUiState.Loading)

    fun getAlbum(id: String) {
        viewModelScope.launch {
            uiState = try {
                val albumsRepository = AlbumsRepositoryImpl()
                val album = albumsRepository.getAlbum(id)
                DataUiState.Success(
                    album
                )
            } catch (e: IOException) {
                Log.d("ERROR_TAG", "Mensaje de error", e)
                DataUiState.Error
            } catch (e: HttpException) {
                Log.d("ERROR_TAG", "Mensaje de error", e)
                DataUiState.Error
            }
        }
    }
}
