package com.miso2023equipo2.vinilos

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasAnyDescendant
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onLast
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onParent
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import com.miso2023equipo2.vinilos.navigation.AppNavigation
import com.miso2023equipo2.vinilos.navigation.AppPages
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class VynilsScreenNavigationTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private lateinit var navController: TestNavHostController

    @Before
    fun setupVinylsNavHost(){
        composeTestRule.setContent {
            navController=TestNavHostController(LocalContext.current).apply{
                navigatorProvider.addNavigator(ComposeNavigator())
            }
            AppNavigation(navController=navController)
        }
    }
    @Test
    fun vinylsNavHost_verifyStartDestination() {
        navController.assertCurrentRouteName(AppPages.HomePage.route)
    }
    @Test
    fun vinylsNavHost_verifyBackNavigationNotShownOnStartOrderScreen(){
        val backText = composeTestRule.activity.getString(R.string.principal_menu_icon)
        composeTestRule.onNodeWithContentDescription(backText).assertDoesNotExist()
    }

    @Test
    fun vinylsNavHost_clickCollection_navigatesToAlbumsScreen(){
        navigateToAlbumCatalogueScreen()
        navController.assertCurrentRouteName(AppPages.AlbumCataloguePage.route)
    }

    private fun navigateToAlbumCatalogueScreen(){
        composeTestRule.onNodeWithStringId(R.string.collectionist_label)
            .performClick()
    }




}

