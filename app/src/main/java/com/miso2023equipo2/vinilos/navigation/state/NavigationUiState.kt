package com.miso2023equipo2.vinilos.navigation.state

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationUiState (
    val logged:Boolean=false,
    val icon:ImageVector?=null,
    @StringRes val iconDescription:Int?=null
)