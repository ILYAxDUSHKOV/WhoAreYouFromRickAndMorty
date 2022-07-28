package com.example.whoareyoufromrickandmorty.network

import retrofit2.http.GET
import retrofit2.http.Path

interface API {

    @GET("api/character/{characterId}")
    suspend fun getPost(
        @Path("characterId") characterId:Int
    ):Model

}