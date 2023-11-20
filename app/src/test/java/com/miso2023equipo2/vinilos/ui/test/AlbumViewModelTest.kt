package com.miso2023equipo2.vinilos.ui.test

import androidx.lifecycle.viewmodel.compose.viewModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.miso2023equipo2.vinilos.data.repository.AlbumsRepository
import com.miso2023equipo2.vinilos.data.repository.AlbumsRepositoryImpl
import com.miso2023equipo2.vinilos.data.repository.ArtistRepository
import com.miso2023equipo2.vinilos.data.repository.ArtistRepositoryImpl
import com.miso2023equipo2.vinilos.fake.FakeDataSource
import com.miso2023equipo2.vinilos.fake.FakeNetworkAlbumsRepository
import com.miso2023equipo2.vinilos.fake.FakeVinylsApiService
import com.miso2023equipo2.vinilos.navigation.state.DataUiState
import com.miso2023equipo2.vinilos.pages.album.AlbumCatalogueViewModel
import com.miso2023equipo2.vinilos.pages.artist.ArtistCatalogueViewModel
import com.miso2023equipo2.vinilos.services.VinylsApiServiceAdapter
import com.miso2023equipo2.vinilos.services.VinylsApiServiceImpl
import com.miso2023equipo2.vinilos.ui.test.rules.TestDispatcherRule
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit

class AlbumViewModelTest {
    @get:Rule
    val testDispatcher= TestDispatcherRule()



    @Test
    fun albumViewModel_getAlbumCatalogue_VerifyCatalogueUiStateSuccess()= runTest{
        val albumCatalogueViewModel = AlbumCatalogueViewModel(
            albumsRepository = FakeNetworkAlbumsRepository()
        )
        val listResult = FakeDataSource.albumList
        assertEquals(

            DataUiState.Success(listResult),
            albumCatalogueViewModel.uiState
        )
    }

}