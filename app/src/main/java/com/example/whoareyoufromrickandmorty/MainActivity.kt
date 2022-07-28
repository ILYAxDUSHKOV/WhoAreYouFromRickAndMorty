package com.example.whoareyoufromrickandmorty

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.whoareyoufromrickandmorty.screens.InfoScreen
import com.example.whoareyoufromrickandmorty.screens.SetupNavGraph
import com.example.whoareyoufromrickandmorty.ui.theme.WhoAreYouFromRickAndMortyTheme
import com.google.accompanist.pager.ExperimentalPagerApi

class MainActivity : ComponentActivity() {

    lateinit var navController:NavHostController //need navigation dependencies
    lateinit var viewModel: MainViewModel

    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhoAreYouFromRickAndMortyTheme {
                navController = rememberNavController()
                viewModel = viewModel()
                SetupNavGraph(
                    navController = navController,
                    viewModel = viewModel
                )
            }
        }
    }
}