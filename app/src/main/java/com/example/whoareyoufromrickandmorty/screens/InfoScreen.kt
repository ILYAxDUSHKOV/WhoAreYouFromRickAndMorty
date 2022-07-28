package com.example.whoareyoufromrickandmorty.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.whoareyoufromrickandmorty.MainViewModel
import com.example.whoareyoufromrickandmorty.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@ExperimentalPagerApi
@Composable
fun InfoScreen(
    navController: NavController,
    viewModel: MainViewModel
){
    //viewModel.getPost() //Ошибка, если нет интернета. Надо обработать.
    //val postResult = viewModel.myResponse.observeAsState().value
    val myResult = viewModel.myResponse.observeAsState().value

    Column(
        modifier = Modifier
            .background(color = Color.Black)
            .fillMaxSize()
            .padding(30.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (myResult != null){
            Card(
                shape = RoundedCornerShape(15.dp)
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(300.dp,300.dp),
                    model = "${myResult.image}",
                    contentDescription = ""
                )
            }

            Text(
                text = "${myResult.name}",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp),
                color = Color.White
            )
        }

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopStart
        ){
            if(myResult != null){
                Column() {
                    Text(
                        text = "Status: "+"${myResult.status}",
                        color = Color.White,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )
                    Text(
                        text = "Species: "+"${myResult.species}",
                        color = Color.White,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )
                    if (myResult.type.isNotEmpty()){
                        Text(
                            text = "Type: "+"${myResult.type}",
                            color = Color.White,
                            fontSize = 20.sp,
                            modifier = Modifier.padding(bottom = 5.dp)
                        )
                    } else {
                        Text(
                            text = "Type: unknown",
                            color = Color.White,
                            fontSize = 20.sp,
                            modifier = Modifier.padding(bottom = 5.dp)
                        )
                    }
                    Text(
                        text = "Gender: "+"${myResult.gender}",
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }
            }

        }
    }
}