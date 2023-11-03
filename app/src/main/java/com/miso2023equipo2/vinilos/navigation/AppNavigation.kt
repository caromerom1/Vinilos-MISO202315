package com.miso2023equipo2.vinilos.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.miso2023equipo2.vinilos.pages.album.AlbumCataloguePage
import com.miso2023equipo2.vinilos.pages.album.AlbumDetailPage
import com.miso2023equipo2.vinilos.pages.HomePage
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import com.miso2023equipo2.vinilos.pages.album.AlbumCatalogueViewModel

@Composable
fun AppNavigation(
    viewModel: NavigationViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val uiState by viewModel.uiState.collectAsState()
    val currentScreen = AppPages.valueOf(
        backStackEntry?.destination?.route ?: AppPages.HomePage.name
    )
    Scaffold (
        topBar ={
            VinylsAppBar(icon=uiState.icon,currentScreen = currentScreen)
        }

    ){  innerPadding->

        NavHost(navController = navController,
            startDestination = AppPages.HomePage.name,
            modifier=modifier.padding(innerPadding)
        ) {
            composable(route = AppPages.HomePage.name) {
                HomePage(
                    onClickCollectorButton={
                        viewModel.setIconMenu(Icons.Filled.Menu)
                        navController.navigate(route = AppPages.AlbumCataloguePage.name)
                    },
                    onClickGuestButton={
                        viewModel.setIconMenu(Icons.Filled.Menu)
                        navController.navigate(route = AppPages.AlbumCataloguePage.name)
                    }
                )
            }
            composable(route = AppPages.AlbumCataloguePage.name) {
                val albumCatalogueViewModel: AlbumCatalogueViewModel =viewModel()
                AlbumCataloguePage(
                    albumCatalogueUiState=albumCatalogueViewModel._uiState,
                    onBackButton={
                        viewModel.setIconMenu(null)
                        navController.popBackStack()
                    },
                    onDetailAlbumButton={
                        navController.navigate(route = AppPages.AlbumDetailPage.name + "/123")
                    }
                )
            }
            composable(route = AppPages.AlbumDetailPage.name + "/{albumId}", arguments = listOf(
                navArgument("albumId") { type = NavType.IntType }
            )) {
                AlbumDetailPage(navController, it.arguments?.getInt("albumId") ?: -1)
            }
        }

    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VinylsAppBar(icon: ImageVector?, currentScreen: AppPages, modifier:Modifier=Modifier){
    CenterAlignedTopAppBar(
        title = {
            Text(stringResource(id = currentScreen.title))
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = Color.Black,
        ),
        navigationIcon = {
            IconButton(onClick = { /* do something */ }) {
                if (icon != null) {
                    Icon(
                        imageVector = icon,
                        contentDescription = "Localized description"
                    )
                }
            }

        }
    )
}
