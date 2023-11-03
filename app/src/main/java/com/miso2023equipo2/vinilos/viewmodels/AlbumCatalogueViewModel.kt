package com.miso2023equipo2.vinilos.viewmodels


import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miso2023equipo2.vinilos.network.VinylsApi
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface AlbumCatalogueUiState {
    data class Success(val albums: String) : AlbumCatalogueUiState
    object Error : AlbumCatalogueUiState
    object Loading : AlbumCatalogueUiState
}
class AlbumCatalogueViewModel : ViewModel(){
    var albumCatalogueUiState: AlbumCatalogueUiState by mutableStateOf(AlbumCatalogueUiState.Loading)
        private set
    init{
        getAlbums()
    }
    private fun getAlbums() {
        viewModelScope.launch {
            albumCatalogueUiState= AlbumCatalogueUiState.Loading

            albumCatalogueUiState=try{
                val listResult=VinylsApi.retrofitService.getAlbums()
                AlbumCatalogueUiState.Success(
                    "Success: ${listResult.size} Mars photos retrieved"
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