package com.miso2023equipo2.vinilos.pages.album

import androidx.camera.core.Camera
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miso2023equipo2.vinilos.R
import com.miso2023equipo2.vinilos.ui.components.ButtonType
import com.miso2023equipo2.vinilos.ui.components.VinylsButton

@Composable
fun AlbumCreatePage(

){ val mediumPadding= dimensionResource(id = R.dimen.padding_medium)
 Column(modifier = Modifier
     .verticalScroll(rememberScrollState())
     .padding(mediumPadding),
     verticalArrangement = Arrangement.Center,
     horizontalAlignment = Alignment.CenterHorizontally) {


     Image(
             painter= painterResource(id = R.drawable.ic_add_photo_camera),
             contentScale= ContentScale.Crop,
             contentDescription = "camara add",
             modifier = Modifier.size(100.dp)
         )



     FormLayout(
         modifier = Modifier
             .fillMaxWidth()
             .wrapContentHeight()
             .padding(mediumPadding)
     )
     Column(
         modifier = Modifier
             .fillMaxWidth()
             .padding(mediumPadding),
         verticalArrangement = Arrangement.spacedBy(mediumPadding),
         horizontalAlignment = Alignment.CenterHorizontally) {

         VinylsButton(
             label = "Guardar",
             onClick = { /*TODO*/ },
             type = ButtonType.PRIMARY,
             modifier = Modifier.fillMaxWidth()
         )

         VinylsButton(
             label = "Cancelar",
             onClick = { /*TODO*/ },
             type = ButtonType.TERTIARY,
             modifier = Modifier.fillMaxWidth()
         )
     }
 }
}
@Composable
fun FormLayout(

    modifier: Modifier = Modifier)
{

    val mediumPadding = dimensionResource(R.dimen.padding_medium)
    Card(
        modifier=modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp))
    {
        Column(
            verticalArrangement = Arrangement.spacedBy(mediumPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(mediumPadding)
        ) {
            OutlinedTextField(
                value = "name",
                onValueChange = { } ,
                singleLine = true,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                    disabledContainerColor = MaterialTheme.colorScheme.surface,
                ),
                label = {Text(text="Nombre")},
                isError =false,

            )
            OutlinedTextField(
                value = "ooo",
                onValueChange = { } ,
                singleLine = true,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                    disabledContainerColor = MaterialTheme.colorScheme.surface,
                ),
                label = {Text(text="Descripción")},
                isError =false,

                )
            OutlinedTextField(
                value = "YYYY/MM/DD",
                onValueChange = { },
                singleLine = true,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                    disabledContainerColor = MaterialTheme.colorScheme.surface,
                ),
                label = {Text(text="Fecha de lanzamiento")},
                isError =false,

                )
            OutlinedTextField(
                value = "MASC",
                onValueChange = { },
                singleLine = true,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                    disabledContainerColor = MaterialTheme.colorScheme.surface,
                ),
                label = {Text(text="Género Musical")},
                isError =false,

                )

            OutlinedTextField(
                value = "Ingresa aquí la informacion detallada relacionada con tu album",
                onValueChange = { },
                singleLine = false,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                    disabledContainerColor = MaterialTheme.colorScheme.surface,
                ),
                label = {Text(text="Descripción")},
                isError =false,

                )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlbumCreatePagePreview(){
    AlbumCreatePage()
}