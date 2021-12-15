package com.example.marvelapp.network

import com.example.marvelapp.model.ResponseAPI
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterService {

    @GET("v1/public/characters")
    fun getCharacter(
        @Query("limit"  ) limit : String,
        @Query("ts"     ) ts    : String,
        @Query("apikey" ) apikey: String,
        @Query("hash"   ) hash  : String
    ): Call<ResponseAPI>
}