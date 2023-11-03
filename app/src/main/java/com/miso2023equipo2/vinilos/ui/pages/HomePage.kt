package com.miso2023equipo2.vinilos.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.miso2023equipo2.vinilos.R
import com.miso2023equipo2.vinilos.ui.components.ButtonType
import com.miso2023equipo2.vinilos.ui.components.VinylsButton
import com.miso2023equipo2.vinilos.ui.navigation.AppPages


@Composable
fun HomePage(onClickCollectionistButton:()->Unit={},onClickGuestButton:()->Unit={}) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()            ,
    ) {
        Spacer(modifier = Modifier.height(64.dp))
        Image(
            painter = painterResource(id = R.drawable.vinyl),
            contentDescription = "Vinyls Logo",
            modifier = Modifier.height(240.dp)
        )
    }
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
    ) {
        Text("¿Cómo desea iniciar la aplicación?", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(32.dp))
        VinylsButton(
            onClick =  onClickCollectionistButton,
            type = ButtonType.PRIMARY,
            label = "Coleccionista",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 64.dp, vertical = 0.dp)
        )
        VinylsButton(
            onClick =  onClickGuestButton ,
            type = ButtonType.TERTIARY,
            label = "Invitado",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 64.dp, vertical = 0.dp)
        )
        Spacer(modifier = Modifier.height(64.dp))
    }
}

@Preview
@Composable
fun HomePagePreview() {

    HomePage()
}