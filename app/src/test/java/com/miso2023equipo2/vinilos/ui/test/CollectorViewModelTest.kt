package com.miso2023equipo2.vinilos.ui.test

import com.miso2023equipo2.vinilos.fake.FakeDataSource
import com.miso2023equipo2.vinilos.fake.FakeNetworkCollectorRepository
import com.miso2023equipo2.vinilos.navigation.state.DataUiState
import com.miso2023equipo2.vinilos.pages.collector.CollectorCatalogueViewModel
import com.miso2023equipo2.vinilos.ui.test.rules.TestDispatcherRule
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class CollectorViewModelTest {
    @get:Rule
    val testDispatcher = TestDispatcherRule()


    @Test
    fun validUiStateSuccess() = runTest {
        val collectorCatalogueViewModel = CollectorCatalogueViewModel(
            collectorsRepository = FakeNetworkCollectorRepository()
        )
        val listResult = FakeDataSource.collectorList
        assertEquals(
            DataUiState.Success(listResult),
            collectorCatalogueViewModel.uiState
        )
    }

}