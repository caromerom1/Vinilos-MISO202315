package com.miso2023equipo2.vinilos.ui.test


import com.miso2023equipo2.vinilos.fake.FakeDataSource
import com.miso2023equipo2.vinilos.fake.FakeNetworkAlbumsRepository
import com.miso2023equipo2.vinilos.navigation.state.DataUiState
import com.miso2023equipo2.vinilos.pages.album.AlbumCatalogueViewModel
import com.miso2023equipo2.vinilos.ui.test.rules.TestDispatcherRule
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

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