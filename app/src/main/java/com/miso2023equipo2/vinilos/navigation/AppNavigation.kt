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
import androidx.navigation.NavHostController
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
import com.miso2023equipo2.vinilos.pages.artist.ArtistCataloguePage
import com.miso2023equipo2.vinilos.pages.artist.ArtistCatalogueViewModel
import com.miso2023equipo2.vinilos.pages.artist.ArtistDetailPage
import com.miso2023equipo2.vinilos.pages.artist.ArtistDetailViewModel
import com.miso2023equipo2.vinilos.pages.collector.CollectorCataloguePage
import com.miso2023equipo2.vinilos.pages.collector.CollectorCatalogueViewModel
import com.miso2023equipo2.vinilos.pages.collector.CollectorDetailPage
import com.miso2023equipo2.vinilos.pages.collector.CollectorDetailViewModel
import com.miso2023equipo2.vinilos.ui.components.NavigationDrawer
import kotlinx.coroutines.launch

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: NavigationViewModel = viewModel(),

    ) {

    val uiState by viewModel.uiState.collectAsState()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val route: String = backStackEntry?.destination?.route ?: AppPages.HomePage.route


    NavigationDrawer(navController = navController, drawerState = drawerState) {
        Scaffold(
            topBar = {
                VinylsAppBar(
                    icon = uiState.icon,
                    iconDescription = uiState.iconDescription,
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
                    val albumCatalogueViewModel: AlbumCatalogueViewModel =
                        viewModel(factory = AlbumCatalogueViewModel.Factory)
                    viewModel.setIconMenu(Icons.Filled.Menu)

                    AlbumCataloguePage(
                        albumCatalogueUiState = albumCatalogueViewModel.uiState,
                        onDetailAlbumButton = {
                            navController.navigate(route = "${AppPages.AlbumDetailPage.route}/$it")
                        }
                    )
                }
                composable(route = AppPages.ArtistCataloguePage.route) {
                    val artistCatalogueViewModel: ArtistCatalogueViewModel =
                        viewModel(factory = ArtistCatalogueViewModel.Factory)
                    viewModel.setIconMenu(Icons.Filled.Menu)
                    ArtistCataloguePage(
                        uiState = artistCatalogueViewModel.uiState,
                        onDetailButton = {
                            navController.navigate(route = "${AppPages.ArtistDetailPage.route}/$it")
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

                    val albumDetailViewModel: AlbumDetailViewModel =
                        viewModel(factory = AlbumDetailViewModel.Factory)

                    albumDetailViewModel.getAlbum(albumId)

                    AlbumDetailPage(
                        albumDetailUiState = albumDetailViewModel.uiState,
                    )
                }
                composable(
                    route = "${AppPages.ArtistDetailPage.route}/{artistId}",
                    arguments = listOf(navArgument("artistId") { type = NavType.StringType })
                ) {
                    val artistId = it.arguments?.getString("artistId")
                    if (artistId == null) {
                        navController.popBackStack()
                        return@composable
                    }

                    viewModel.setIconMenu(Icons.Filled.ArrowBack)

                    val artistDetailViewModel: ArtistDetailViewModel =
                        viewModel(factory = ArtistDetailViewModel.Factory)

                    artistDetailViewModel.getArtist(artistId)

                    ArtistDetailPage(
                        artistDetailUiState = artistDetailViewModel.uiState,
                    )
                }
                composable(route = AppPages.CollectorCataloguePage.route) {
                    val collectorCatalogueViewModel: CollectorCatalogueViewModel =
                        viewModel(factory = CollectorCatalogueViewModel.Factory)
                    viewModel.setIconMenu(Icons.Filled.Menu)
                    CollectorCataloguePage(
                        uiState = collectorCatalogueViewModel.uiState,
                        onDetailButton = {
                            navController.navigate(route = "${AppPages.CollectorDetailPage.route}/$it")
                        }
                    )
                }
                composable(
                    route = "${AppPages.CollectorDetailPage.route}/{collectorId}",
                    arguments = listOf(navArgument("collectorId") { type = NavType.StringType })
                ) {
                    val collectorId = it.arguments?.getString("collectorId")
                    if (collectorId == null) {
                        navController.popBackStack()
                        return@composable
                    }

                    viewModel.setIconMenu(Icons.Filled.ArrowBack)

                    val collectorDetailViewModel: CollectorDetailViewModel =
                        viewModel(factory = CollectorDetailViewModel.Factory)

                    collectorDetailViewModel.getCollector(collectorId)

                    CollectorDetailPage(
                        uiState = collectorDetailViewModel.uiState,
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
    iconDescription: Int?,
    route: String,
    navController: NavController,
    drawerState: DrawerState,
    modifier: Modifier = Modifier
) {
    val currentScreen = with(route) {
        when {
            equals(AppPages.HomePage.route) -> stringResource(id = R.string.home_title)
            equals(AppPages.AlbumCataloguePage.route) -> stringResource(id = R.string.catalogue_album_title)
            equals(AppPages.ArtistCataloguePage.route) -> stringResource(id = R.string.artist_title)
            equals(AppPages.CollectorCataloguePage.route) -> stringResource(id = R.string.collector_title)
            startsWith(AppPages.ArtistDetailPage.route) -> stringResource(id = R.string.detail_artist_title)
            startsWith(AppPages.AlbumDetailPage.route) -> stringResource(id = R.string.detail_album_title)
            startsWith(AppPages.CollectorDetailPage.route) -> stringResource(id = R.string.detail_collector_title)
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
                        contentDescription = iconDescription?.let { stringResource(id = it) }
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
                iconDescription = iconDescription
            )
        },
        modifier = modifier,
    )
}

@Composable
fun NavigationIcon(
    icon: ImageVector,
    iconDescription: Int?,
    route: String,
    drawerState: DrawerState
) {
    val scope = rememberCoroutineScope()

    IconButton(onClick = {
        scope.launch {
            if (route == AppPages.HomePage.route) return@launch
            drawerState.open()
        }
    }) {
        Icon(
            imageVector = icon,
            contentDescription = iconDescription?.let { stringResource(id = it) }
        )
    }
}
