package com.miso2023equipo2.vinilos.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.miso2023equipo2.vinilos.utils.parseDateFromString

data class ItemDetail(
    val name: String,
    val value: String,
    val isDate: Boolean = false,
    val hasImage: Boolean = false
)


@Composable
fun DetailedList(details: List<ItemDetail>) {

    details.forEach {
        Row(verticalAlignment = if (it.hasImage) Alignment.CenterVertically else Alignment.Top) {
            if (it.hasImage) {
                AsyncImage(
                    modifier = Modifier
                        .size(130.dp)
                        .padding(4.dp),
                    model = it.name,
                    contentDescription = null
                )
            } else {
                Text(
                    text = it.name, fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .width(130.dp)
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
            Text(
                text = if (it.isDate) parseDateFromString(it.value) else it.value,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                fontSize = if (!it.hasImage) TextUnit.Unspecified else 20.sp

            )
        }
    }

}