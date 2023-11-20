package com.miso2023equipo2.vinilos.pages.collector

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
import com.miso2023equipo2.vinilos.data.model.Collector
import com.miso2023equipo2.vinilos.data.repository.CollectorRepository
import com.miso2023equipo2.vinilos.navigation.state.DataUiState
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


class CollectorDetailViewModel(
    private val collectorsRepository: CollectorRepository
) : ViewModel() {
    var uiState: DataUiState<Collector> by mutableStateOf(DataUiState.Loading)


    fun getCollector(id: String) {
        viewModelScope.launch {
            uiState = try {
                val collector = collectorsRepository.getCollector(id)
                DataUiState.Success(
                    collector
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

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as VinylosApplication)
                val collectorsRepository = application.container.collectorRepository
                CollectorDetailViewModel(collectorsRepository = collectorsRepository)
            }
        }
    }


}