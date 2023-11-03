package com.miso2023equipo2.vinilos.ui.uistate

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.vector.ImageVector
import com.miso2023equipo2.vinilos.R

data class NavigationUiState (
    val logged:Boolean=false,
    val icon:ImageVector?=null
)