package com.miso2023equipo2.vinilos.ui.components

import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import java.text.SimpleDateFormat
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateSelector(
    onDateSelected: (String) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState(selectableDates = object : SelectableDates {
        override fun isSelectableDate(utcTimeMillis: Long): Boolean {
            return utcTimeMillis <= System.currentTimeMillis()
        }
    })

    val selectedDate = datePickerState.selectedDateMillis?.let {
        convertMillisToDate(it)
    } ?: ""

    DatePickerDialog(
        onDismissRequest = { onDismiss() },
        confirmButton = {
            VinylsButton(
                onClick = { onDateSelected(selectedDate) },
                type = ButtonType.TERTIARY,
                label = "OK",
                modifier = Modifier
            )
        },
        dismissButton = {
            VinylsButton(
                onClick = { onDismiss() },
                type = ButtonType.TERTIARY,
                label = "Cancel",
                modifier = Modifier
            )
        }
    ) {
        DatePicker(
            state = datePickerState
        )
    }
}


private fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy")
    return formatter.format(Date(millis))
}

@Preview(showBackground = true)
@Composable
fun DateSelectorPreview() {
    DateSelector(onDateSelected = {}, onDismiss = {})
}