package com.miso2023equipo2.vinilos.pages.album

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AlbumCreatePage(

){
 Column(modifier=Modifier.fillMaxWidth()) {
     Text(text="imagen")
     Text(text = "nombre")
     Text(text = "Fecha")
     Text(text = "Genero")
 }
}

@Preview(showBackground = true)
@Composable
fun AlbumCreatePagePreview(){
    AlbumCreatePage()
}