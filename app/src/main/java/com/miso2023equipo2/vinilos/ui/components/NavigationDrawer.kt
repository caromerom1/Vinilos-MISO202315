package com.miso2023equipo2.vinilos.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.miso2023equipo2.vinilos.ui.theme.Purple100
import com.miso2023equipo2.vinilos.ui.theme.TextBlack

@Preview (showBackground = true)
@Composable
fun NavigationDrawer() {

    val items = listOf(
        "Álbumes",
        "Artistas",
        "Coleccionistas"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple100)
            .zIndex(1f)
            .padding(horizontal = 2.dp, vertical = 24.dp)
    ) {
        items.forEach { item ->
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = TextBlack
                ),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(
                        text = item,
                        textAlign = TextAlign.Start // You can also explicitly set the text alignment
                    )
                }
            }

//            Text(text = item, modifier = Modifier
//                .padding(vertical = 10.dp)
//                .clickable { selectedItem = item })
        }
    }

    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .zIndex(1f)
            .padding(bottom = 24.dp)
    ) {
        VinylsButton(
            onClick = {},
            type = ButtonType.TERTIARY,
            label = "Salir",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 64.dp, vertical = 0.dp)
        )
    }

}