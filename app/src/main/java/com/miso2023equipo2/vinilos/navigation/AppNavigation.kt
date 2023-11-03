package com.miso2023equipo2.vinilos.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.miso2023equipo2.vinilos.pages.AlbumCataloguePage
import com.miso2023equipo2.vinilos.pages.AlbumDetailPage
import com.miso2023equipo2.vinilos.pages.HomePage

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppPages.HomePage.route) {
        composable(route = AppPages.HomePage.route) {
            HomePage(navController)
        }
        composable(route = AppPages.AlbumCataloguePage.route) {
            AlbumCataloguePage(navController)
        }
        composable(route = AppPages.AlbumDetailPage.route + "/{albumId}", arguments = listOf(
            navArgument("albumId") { type = NavType.IntType }
        )) {
            AlbumDetailPage(navController, it.arguments?.getInt("albumId") ?: -1)
        }
    }
}
