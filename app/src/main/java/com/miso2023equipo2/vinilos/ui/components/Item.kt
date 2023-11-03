package com.miso2023equipo2.vinilos.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun Item(text: String, imageUrl: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(
                top = 10.dp,
                start = 20.dp,
                bottom = 10.dp,
                end = 20.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = imageUrl,
            contentScale = ContentScale.Inside,
            contentDescription = text,
            modifier = Modifier
                .height(70.dp)
                .width(70.dp)
        )
        Spacer(Modifier.width(20.dp))
        Text(text = text, fontSize = 20.sp)
    }
}