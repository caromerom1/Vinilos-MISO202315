package com.miso2023equipo2.vinilos.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.miso2023equipo2.vinilos.R
import com.miso2023equipo2.vinilos.pages.HomePage
import com.miso2023equipo2.vinilos.pages.album.AlbumCataloguePage
import com.miso2023equipo2.vinilos.pages.album.AlbumCatalogueViewModel
import com.miso2023equipo2.vinilos.pages.album.AlbumDetailPage
import com.miso2023equipo2.vinilos.pages.album.AlbumDetailViewModel
import com.miso2023equipo2.vinilos.ui.components.NavigationDrawer
import kotlinx.coroutines.launch

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    viewModel: NavigationViewModel = viewModel(),
) {
    val navController = rememberNavController()
    val uiState by viewModel.uiState.collectAsState()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val route: String = backStackEntry?.destination?.route ?: AppPages.HomePage.route

    NavigationDrawer(navController = navController, drawerState = drawerState) {
        Scaffold(
            topBar = {
                VinylsAppBar(
                    icon = uiState.icon,
                    route = route,
                    navController = navController,
                    drawerState = drawerState
                )
            }

        ) { innerPadding ->

            NavHost(
                navController = navController,
                startDestination = AppPages.HomePage.route,
                modifier = modifier.padding(innerPadding)
            ) {
                composable(route = AppPages.HomePage.route) {
                    viewModel.setIconMenu(null)
                    HomePage(
                        onClickCollectorButton = {
                            navController.navigate(route = AppPages.AlbumCataloguePage.route)
                        },
                        onClickGuestButton = {
                            navController.navigate(route = AppPages.AlbumCataloguePage.route)
                        }
                    )
                }
                composable(route = AppPages.AlbumCataloguePage.route) {
                    val albumCatalogueViewModel: AlbumCatalogueViewModel = viewModel()
                    viewModel.setIconMenu(Icons.Filled.Menu)

                    AlbumCataloguePage(
                        albumCatalogueUiState = albumCatalogueViewModel.uiState,
                        onDetailAlbumButton = {
                            navController.navigate(route = "${AppPages.AlbumDetailPage.route}/$it")
                        }
                    )
                }
                composable(
                    route = "${AppPages.AlbumDetailPage.route}/{albumId}",
                    arguments = listOf(navArgument("albumId") { type = NavType.StringType })
                ) {
                    val albumId = it.arguments?.getString("albumId")
                    if (albumId == null) {
                        navController.popBackStack()
                        return@composable
                    }

                    viewModel.setIconMenu(Icons.Filled.ArrowBack)

                    val albumDetailViewModel: AlbumDetailViewModel = viewModel()

                    albumDetailViewModel.getAlbum(albumId)

                    AlbumDetailPage(
                        albumDetailUiState = albumDetailViewModel.uiState,
                    )
                }
            }

        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VinylsAppBar(
    icon: ImageVector?,
    route: String,
    navController: NavController,
    drawerState: DrawerState,
    modifier: Modifier = Modifier
) {
    val currentScreen = with(route) {
        when {
            equals(AppPages.HomePage.route) -> stringResource(id = R.string.home_title)
            equals(AppPages.AlbumCataloguePage.route) -> stringResource(id = R.string.catalogue_album_title)
            startsWith(AppPages.AlbumDetailPage.route) -> stringResource(id = R.string.detail_album_title)
            else -> stringResource(id = R.string.home_title)
        }
    }

    if (icon == Icons.Filled.ArrowBack) {
        TopAppBar(
            title = {
                Text(text = currentScreen)
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = Color.Black,
            ),
            navigationIcon = {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        imageVector = icon,
                        contentDescription = "Localized description"
                    )
                }
            },
            modifier = modifier,
        )
        return
    }

    if (icon == null) {
        CenterAlignedTopAppBar(
            title = {
                Text(text = currentScreen)
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = Color.Black,
            ),
            modifier = modifier,
        )
        return
    }

    CenterAlignedTopAppBar(
        title = {
            Text(text = currentScreen)
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = Color.Black,
        ),
        navigationIcon = {
            NavigationIcon(
                icon = icon,
                route = route,
                drawerState = drawerState,
            )
        },
        modifier = modifier,
    )
}

@Composable
fun NavigationIcon(icon: ImageVector, route: String, drawerState: DrawerState) {
    val scope = rememberCoroutineScope()

    IconButton(onClick = {
        scope.launch {
            if (route == AppPages.HomePage.route) return@launch
            drawerState.open()
        }
    }) {
        Icon(
            imageVector = icon,
            contentDescription = "Localized description"
        )
    }
}
