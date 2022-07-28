package com.example.whoareyoufromrickandmorty.screens

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build.VERSION.SDK_INT
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.core.content.getSystemService
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.example.whoareyoufromrickandmorty.MainViewModel
import com.example.whoareyoufromrickandmorty.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

//Start Screen
@Composable
fun StartScreen(
    navController: NavController,
    viewModel:MainViewModel
){

    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Who are you from...",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(bottom = 20.dp),
                style = MaterialTheme.typography.h1
            )
            Image(
                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(context).data(R.drawable.load).build(),
                    imageLoader = imageLoader
                ),
                modifier = Modifier
                    .size(300.dp, 300.dp),
                contentDescription = "",
            )

            Text(
                text = "...Rick and Morty?",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(top = 20.dp,bottom = 40.dp),
                style = MaterialTheme.typography.h1
            )

            FloatingActionButton(
                modifier = Modifier
                    .border(2.dp, Color.White, CircleShape),
                backgroundColor = Color.Black,
                onClick = {
                    if (connectivityManager.activeNetwork!=null){
                        var random = (0..826).shuffled().random()
                        viewModel.getPost(random)
                        navController.navigate(Screens.InfoScreen.route)
                    } else {
                        Toast.makeText(context,"Check your internet connection, bro",Toast.LENGTH_LONG).show()
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.PlayArrow,
                    contentDescription = "",
                    tint = Color.White
                )
            }
            FloatingActionButton(
                modifier = Modifier
                    .border(2.dp, Color.White, CircleShape),
                backgroundColor = Color.Black,
                onClick = {
                    navController.navigate(Screens.WebScreen.route)
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.PlayArrow,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
    }
}

