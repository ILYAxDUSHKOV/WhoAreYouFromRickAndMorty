package com.example.whoareyoufromrickandmorty.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Experimntal(){
    Box(
        Modifier.fillMaxSize()
    ){
        Text(text = "1", Modifier.align(Alignment.CenterStart))
        Text(text = "2", Modifier.align(Alignment.TopCenter))
        Text(text = "3", Modifier.align(Alignment.CenterEnd))
        Text(text = "4", Modifier.align(Alignment.BottomCenter))
    }
}