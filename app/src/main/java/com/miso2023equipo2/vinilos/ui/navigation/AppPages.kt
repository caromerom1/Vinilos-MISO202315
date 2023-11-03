package com.miso2023equipo2.vinilos.ui.navigation

import androidx.annotation.StringRes
import com.miso2023equipo2.vinilos.R

enum class AppPages(@StringRes val title: Int) {
    HomePage(title=R.string.home_title),
    AlbumCataloguePage(title=R.string.catalogue_album_title),
    AlbumDetailPage(title=R.string.detail_album_tittle),
}
