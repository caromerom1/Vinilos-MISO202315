package com.miso2023equipo2.vinilos.pages.collector

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
import com.miso2023equipo2.vinilos.data.model.Collector
import com.miso2023equipo2.vinilos.data.repository.AlbumsRepository
import com.miso2023equipo2.vinilos.data.repository.CollectorRepository
import com.miso2023equipo2.vinilos.navigation.state.DataUiState
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


class CollectorDetailViewModel(
    private val collectorsRepository: CollectorRepository,
    private val albumsRepository: AlbumsRepository,
) : ViewModel() {
    var uiState: DataUiState<Pair<Collector, List<Album>>> by mutableStateOf(DataUiState.Loading)


    fun getCollector(id: String) {
        viewModelScope.launch {
            uiState = try {
                val collector = collectorsRepository.getCollector(id)
                val collectorAlbums = collector.collectorAlbums.map { it.id }
                val albums = mutableListOf<Album>()

                collectorAlbums.forEach {
                    val album = albumsRepository.getAlbum(it.toString())
                    albums += album
                }
                val data = Pair(collector, albums)
                DataUiState.Success(
                    data
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
                val collectorsRepository = application.container.collectorRepository
                val albumsRepository = application.container.albumsRepository
                CollectorDetailViewModel(
                    collectorsRepository = collectorsRepository,
                    albumsRepository = albumsRepository
                )
            }
        }
    }


}