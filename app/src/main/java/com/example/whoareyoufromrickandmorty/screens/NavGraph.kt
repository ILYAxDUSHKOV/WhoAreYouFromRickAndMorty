package com.example.whoareyoufromrickandmorty.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.whoareyoufromrickandmorty.MainViewModel
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun SetupNavGraph(
    navController:NavHostController,
    viewModel:MainViewModel
){
    NavHost(
        navController = navController,
        startDestination = Screens.StartScreen.route
        ){
        composable(
            route = Screens.StartScreen.route
        ) {
            StartScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(
            route = Screens.InfoScreen.route
        ){
            InfoScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(Screens.WebScreen.route){
            WebScreen()
        }
    }
}