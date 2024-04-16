package com.example.retrofitsample002.data.api

class ApiHelper(private val apiService: ApiService) {
    suspend fun getRickAndMortyObject() = apiService.getRickAndMortyObject()
}