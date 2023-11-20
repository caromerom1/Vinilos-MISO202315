package com.miso2023equipo2.vinilos.navigation

sealed class User(val rol:String) {
    object CollectionRol : User(rol="collection")
    object GuessedRol : User(rol="guessed")
}