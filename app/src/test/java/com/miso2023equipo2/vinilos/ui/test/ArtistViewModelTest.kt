package com.miso2023equipo2.vinilos.ui.test

import com.miso2023equipo2.vinilos.fake.FakeDataSource
import com.miso2023equipo2.vinilos.fake.FakeNetworkArtistRepository
import com.miso2023equipo2.vinilos.navigation.state.DataUiState
import com.miso2023equipo2.vinilos.pages.artist.ArtistCatalogueViewModel
import com.miso2023equipo2.vinilos.ui.test.rules.TestDispatcherRule
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class ArtistViewModelTest {
    @get:Rule
    val testDispatcher= TestDispatcherRule()



    @Test
    fun validUiStateSuccess()= runTest{
        val artistCatalogueViewModel = ArtistCatalogueViewModel(
            artistRepository = FakeNetworkArtistRepository()
        )
        val listResult = FakeDataSource.artistList
        assertEquals(

            DataUiState.Success(listResult),
            artistCatalogueViewModel.uiState
        )
    }

}