package com.example.whoareyoufromrickandmorty.screens

sealed class Screens(val route:String) {
    object StartScreen:Screens(route = "start_screen")
    object InfoScreen:Screens(route = "info_screen")

    object WebScreen:Screens("web_screen")
    object ExperimentalScreen:Screens("exp_screen")
}