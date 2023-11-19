package com.miso2023equipo2.vinilos.pages.artist

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.miso2023equipo2.vinilos.VinylosApplication
import com.miso2023equipo2.vinilos.data.model.Album
import com.miso2023equipo2.vinilos.data.model.Artist
import com.miso2023equipo2.vinilos.data.repository.ArtistRepository
import com.miso2023equipo2.vinilos.navigation.state.DataUiState
import com.miso2023equipo2.vinilos.pages.album.AlbumCatalogueViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class ArtistCatalogueViewModel(
    private val artistRepository: ArtistRepository
) :ViewModel(){
    var uiState: DataUiState<List<Artist>> by mutableStateOf(DataUiState.Loading)
    init{
        getArtist()
    }
    private fun getArtist(){
        viewModelScope.launch {
            uiState=try{
                val listResult = artistRepository.getArtists()
                DataUiState.Success(
                    listResult
                )
            }catch (e:IOException){
                Log.d("ERROR_TAG", "Mensaje de error", e)
                DataUiState.Error
            }catch (e: HttpException) {
                Log.d("ERROR_TAG", "Mensaje de error", e)
                DataUiState.Error
            }
        }
    }
    companion object{
        val Factory: ViewModelProvider.Factory= viewModelFactory {
            initializer {
                val application=(this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as VinylosApplication)
                val albumRepository=application.container.artistRepository
                ArtistCatalogueViewModel(artistRepository=albumRepository)
            }
        }
    }
}