package com.miso2023equipo2.vinilos.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.miso2023equipo2.vinilos.navigation.AppPages
import kotlinx.coroutines.launch

data class NavigationItem(val label: String, val action: () -> Unit)


@Composable
fun NavigationDrawer(
    drawerState: DrawerState,
    navController: NavController,
    content: @Composable () -> Unit
) {

    val scope = rememberCoroutineScope()

    val menus = listOf(
        NavigationItem("Álbumes") { navController.navigate(route = AppPages.AlbumCataloguePage.route) },
        NavigationItem("Artistas") { navController.navigate(route=AppPages.ArtistCataloguePage.route) },
        NavigationItem("Coleccionistas") { /* TODO: add route */ },

    )
    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = navController.currentBackStackEntry?.destination?.route != AppPages.HomePage.route,
        drawerContent = {
            ModalDrawerSheet {
                Column {
                    menus.forEach {
                        NavigationDrawerItem(
                            label = { Text(text = it.label) },
                            selected = false,
                            onClick = {
                                it.action()
                                scope.launch {
                                    drawerState.close()
                                }
                            }
                        )
                    }
                }
                Column(
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 24.dp)
                ) {
                    VinylsButton(
                        onClick = {
                            navController.navigate(route = AppPages.HomePage.route)
                            scope.launch {
                                drawerState.close()
                            }
                        },
                        type = ButtonType.TERTIARY,
                        label = "Salir",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 64.dp, vertical = 0.dp)
                    )
                }
            }
        }
    ) {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationDrawerPreview() {
    NavigationDrawer(
        drawerState = rememberDrawerState(initialValue = DrawerValue.Open),
        rememberNavController()
    ) {}
}