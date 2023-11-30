package com.miso2023equipo2.vinilos.navigation

sealed class User(val role: String) {
    object Collector : User(role = "collector")
    object Guest : User(role = "guest")
}