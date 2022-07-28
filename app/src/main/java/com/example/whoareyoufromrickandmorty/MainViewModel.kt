package com.example.whoareyoufromrickandmorty

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whoareyoufromrickandmorty.network.Model
import com.example.whoareyoufromrickandmorty.network.Network
import kotlinx.coroutines.launch

class MainViewModel():ViewModel() {

    val myResponse:MutableLiveData<Model> = MutableLiveData()

    fun getPost(characterId:Int){
        viewModelScope.launch {
            myResponse.value = Network.retrofit.getPost(characterId)
        }
    }
}