package com.miso2023equipo2.vinilos.pages.album

import android.widget.Toast
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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.miso2023equipo2.vinilos.R
import com.miso2023equipo2.vinilos.data.model.AlbumCreate
import com.miso2023equipo2.vinilos.navigation.AppPages
import com.miso2023equipo2.vinilos.navigation.state.DataUiState
import com.miso2023equipo2.vinilos.ui.components.ButtonType
import com.miso2023equipo2.vinilos.ui.components.DateSelector
import com.miso2023equipo2.vinilos.ui.components.VinylsButton

data class AlbumCreatePageState(
    val name: MutableState<String>,
    val description: MutableState<String>,
    val date: MutableState<String>,
    val genre: MutableState<String>,
)

@Composable
fun AlbumCreatePage(
    albumCreateViewModel: AlbumCreateViewModel,
    navController: NavController
) {
    val mediumPadding = dimensionResource(id = R.dimen.padding_medium)

    val formState = AlbumCreatePageState(
        name = remember { mutableStateOf("") },
        description = remember { mutableStateOf("") },
        date = remember { mutableStateOf("") },
        genre = remember { mutableStateOf("") },
    )
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
            formState = formState,
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
                label = stringResource(id = R.string.button_save),
                onClick = {
                    Toast.makeText(
                        navController.context,
                        "Album creado",
                        Toast.LENGTH_SHORT
                    ).show()
                    albumCreateViewModel.createAlbum(
                        AlbumCreate(
                            name = formState.name.value,
                            description = formState.description.value,
                            releaseDate = formState.date.value,
                            genre = formState.genre.value,
                            cover = "test-cover",
                            recordLabel = "Sony Music"
                        ),
                        navController
                    )
                },
                type = ButtonType.PRIMARY,
            )

            Spacer(modifier = Modifier.size(32.dp))

            VinylsButton(
                label = stringResource(id = R.string.button_cancel),
                onClick = { navController.popBackStack() },
                type = ButtonType.SECONDARY,
            )

            when (albumCreateViewModel.uiState) {
                is DataUiState.Success -> {
                    navController.navigate(route = AppPages.AlbumCataloguePage.route)
                }

                else -> {}
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormLayout(
    modifier: Modifier = Modifier,
    formState: AlbumCreatePageState
) {
    val mediumPadding = dimensionResource(R.dimen.padding_medium)
    val isSelectingDate = remember { mutableStateOf(false) }
    val expanded = remember { mutableStateOf(false) }

    val genreOptions = listOf("Classical", "Salsa", "Rock", "Folk")

    val (name, description, date, genre) = formState

    Column(
        verticalArrangement = Arrangement.spacedBy(mediumPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(mediumPadding)
    ) {
        OutlinedTextField(
            value = name.value,
            placeholder = { Text(stringResource(id = R.string.create_album_name_placeholder))},
            onValueChange = { newText -> name.value = newText },
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.fillMaxWidth(),
            label = { Text(stringResource(id = R.string.create_album_name)) },
            isError = false,

            )
        OutlinedTextField(
            value = description.value,
            placeholder = { Text(stringResource(id = R.string.create_album_description_placeholder)) },
            onValueChange = { newText -> description.value = newText },
            singleLine = false,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.fillMaxWidth(),
            label = { Text(stringResource(id = R.string.create_album_description)) },
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
            label = { Text(stringResource(id = R.string.create_album_release_date)) },
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
                placeholder = { Text(stringResource(id = R.string.create_album_genre_placeholder)) },
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