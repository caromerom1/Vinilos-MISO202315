package com.miso2023equipo2.vinilos.pages.collector

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.miso2023equipo2.vinilos.App
import com.miso2023equipo2.vinilos.data.model.Collector
import com.miso2023equipo2.vinilos.data.repository.CollectorRepository
import com.miso2023equipo2.vinilos.navigation.state.DataUiState
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


class CollectorCatalogueViewModel(
    private val collectorsRepository: CollectorRepository
) : ViewModel() {
    var uiState: DataUiState<List<Collector>> by mutableStateOf(DataUiState.Loading)

    init {
        getCollectors()
    }

    private fun getCollectors() {
        viewModelScope.launch {
            uiState = try {
                val listResult = collectorsRepository.getCollectors()
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
                val application = (this[APPLICATION_KEY] as App)
                val collectorsRepository = application.container.collectorRepository
                CollectorCatalogueViewModel(collectorsRepository = collectorsRepository)
            }
        }
    }
}
