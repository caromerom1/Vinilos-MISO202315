package com.miso2023equipo2.vinilos.pages.album


import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miso2023equipo2.vinilos.data.repository.AlbumsRepositoryImpl
import com.miso2023equipo2.vinilos.navigation.state.AlbumDetailUiState
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


class AlbumDetailViewModel : ViewModel() {
    var uiState: AlbumDetailUiState by mutableStateOf(AlbumDetailUiState.Loading)

    fun getAlbum(id: String) {
        viewModelScope.launch {
            uiState = try {
                val albumsRepository = AlbumsRepositoryImpl()
                val album = albumsRepository.getAlbum(id)
                AlbumDetailUiState.Success(
                    album
                )
            } catch (e: IOException) {
                Log.d("ERROR_TAG", "Mensaje de error", e)
                AlbumDetailUiState.Error
            } catch (e: HttpException) {
                Log.d("ERROR_TAG", "Mensaje de error", e)
                AlbumDetailUiState.Error
            }
        }
    }
}
