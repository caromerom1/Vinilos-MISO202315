package com.miso2023equipo2.vinilos.viewmodels


import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miso2023equipo2.vinilos.data.repository.NetworkAlbumsRepository
import com.miso2023equipo2.vinilos.data.uistate.AlbumCatalogueUiState
import com.miso2023equipo2.vinilos.network.VinylsApi
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


class AlbumCatalogueViewModel : ViewModel(){
    var _uiState: AlbumCatalogueUiState by mutableStateOf(AlbumCatalogueUiState.Loading)
        private set
    init{
        getAlbums()
    }
    private fun getAlbums() {
        viewModelScope.launch {
            _uiState= AlbumCatalogueUiState.Loading

            _uiState=try{
                val albumsRepository=NetworkAlbumsRepository()
                val listResult=albumsRepository.getAlbums()
                AlbumCatalogueUiState.Success(
                    listResult
                )
            } catch (e: IOException){
                Log.d("ERROR_TAG","Mensaje de error",e)
                AlbumCatalogueUiState.Error
            } catch (e: HttpException){
                Log.d("ERROR_TAG","Mensaje de error",e)
                AlbumCatalogueUiState.Error
            }
        }
    }
}