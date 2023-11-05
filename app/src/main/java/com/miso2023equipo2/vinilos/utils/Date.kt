package com.miso2023equipo2.vinilos.utils

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun parseDateFromString(date: String): String {
    return try {
        ZonedDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME)
            .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
    } catch (e: Exception) {
        date
    }
}