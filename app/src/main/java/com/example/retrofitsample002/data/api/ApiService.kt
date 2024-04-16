package com.example.retrofitsample002.data.api
import com.example.retrofitsample002.data.model.rickAndMorty
import retrofit2.http.GET

interface ApiService {
    @GET("api/character")

    suspend fun getRickAndMortyObject() : rickAndMorty
}