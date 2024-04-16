package com.example.retrofitsample002.data.repository

import com.example.retrofitsample002.data.api.ApiHelper

class HomeRepository(private val apiHelper:ApiHelper) {
    suspend fun getRickAndMortyObject() = apiHelper.getRickAndMortyObject()
}