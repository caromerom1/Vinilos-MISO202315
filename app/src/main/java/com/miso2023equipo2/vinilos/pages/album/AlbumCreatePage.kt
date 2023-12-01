package com.miso2023equipo2.vinilos.pages.album

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.miso2023equipo2.vinilos.R
import com.miso2023equipo2.vinilos.ui.components.ButtonType
import com.miso2023equipo2.vinilos.ui.components.DateSelector
import com.miso2023equipo2.vinilos.ui.components.VinylsButton

@Composable
fun AlbumCreatePage(

    navController: NavController

) {
    val mediumPadding = dimensionResource(id = R.dimen.padding_medium)
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(mediumPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Image(
            painter = painterResource(id = R.drawable.ic_add_photo_camera),
            contentScale = ContentScale.Crop,
            contentDescription = "camara add",
            modifier = Modifier.size(100.dp)
        )



        FormLayout(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(mediumPadding)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(mediumPadding),
            horizontalArrangement = Arrangement.Center,
        ) {

            VinylsButton(
                label = "Guardar",
                onClick = { navController.popBackStack() },
                type = ButtonType.PRIMARY,
            )

            Spacer(modifier = Modifier.size(32.dp))

            VinylsButton(
                label = "Cancelar",
                onClick = { navController.popBackStack() },
                type = ButtonType.SECONDARY,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormLayout(
    modifier: Modifier = Modifier
) {
    val mediumPadding = dimensionResource(R.dimen.padding_medium)
    val isSelectingDate = remember { mutableStateOf(false) }
    val expanded = remember { mutableStateOf(false) }

    val genreOptions = listOf("Classical", "Salsa", "Rock", "Folk")

    val name = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }
    val date = remember { mutableStateOf("") }
    val genre = remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.spacedBy(mediumPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(mediumPadding)
    ) {
        OutlinedTextField(
            value = name.value,
            placeholder = { Text("Nombre del álbum") },
            onValueChange = { newText -> name.value = newText },
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Nombre") },
            isError = false,

            )
        OutlinedTextField(
            value = description.value,
            placeholder = { Text("Descripción del álbum") },
            onValueChange = { newText -> description.value = newText },
            singleLine = false,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Descripción") },
            isError = false,
        )

        OutlinedTextField(

            value = date.value,
            onValueChange = { },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { isSelectingDate.value = true }),
            shape = MaterialTheme.shapes.large,
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "Calendar",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable(onClick = { isSelectingDate.value = true })
                )
            },
            label = { Text(text = "Fecha de lanzamiento") },
            isError = false,
            readOnly = true,
            enabled = false,
            colors = OutlinedTextFieldDefaults.colors(
                disabledTextColor = MaterialTheme.colorScheme.onSurface,
                disabledBorderColor = MaterialTheme.colorScheme.outline,
                disabledLeadingIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                disabledTrailingIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                disabledLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
                //For Icons
                disabledPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        )

        ExposedDropdownMenuBox(
            expanded = expanded.value,
            onExpandedChange = { expanded.value = !expanded.value }) {
            OutlinedTextField(
                value = genre.value, onValueChange = {},
                readOnly = true,
                placeholder = { Text("Género") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded.value) },
                shape = MaterialTheme.shapes.large,
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
            )
            ExposedDropdownMenu(
                expanded = expanded.value,
                onDismissRequest = { expanded.value = false }) {
                genreOptions.forEach { genreOption ->
                    DropdownMenuItem(
                        onClick = {
                            genre.value = genreOption
                            expanded.value = false
                        },
                        text = { Text(text = genreOption) },
                    )
                }

            }
        }


        if (isSelectingDate.value) {
            DateSelector(onDateSelected = {
                date.value = it
                isSelectingDate.value = false
            }, onDismiss = {
                isSelectingDate.value = false
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlbumCreatePagePreview() {
    AlbumCreatePage(navController = rememberNavController())
}