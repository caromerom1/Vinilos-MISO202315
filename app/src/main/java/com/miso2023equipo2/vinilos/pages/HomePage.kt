package com.miso2023equipo2.vinilos.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miso2023equipo2.vinilos.R
import com.miso2023equipo2.vinilos.ui.components.ButtonType
import com.miso2023equipo2.vinilos.ui.components.VinylsButton


@Composable
fun HomePage(
    onClickCollectorButton: () -> Unit = {},
    onClickGuestButton: () -> Unit = {}
) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize(),
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
        Text(stringResource(id = R.string.home_start_message), fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(32.dp))
        VinylsButton(
            onClick = onClickCollectorButton,
            type = ButtonType.PRIMARY,
            label = stringResource(id = R.string.collector_label) ,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 64.dp, vertical = 0.dp)
        )
        VinylsButton(
            onClick = onClickGuestButton,
            type = ButtonType.TERTIARY,
            label = stringResource(id = R.string.guessed_label),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 64.dp, vertical = 0.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Preview (showBackground = true)
@Composable
fun HomePagePreview() {

    HomePage()
}