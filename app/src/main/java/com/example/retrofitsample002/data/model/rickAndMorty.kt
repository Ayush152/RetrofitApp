package com.example.retrofitsample002.data.model

import com.google.gson.annotations.SerializedName

data class rickAndMorty(
    @SerializedName("results")
    val results: List<CharacterDetails>
)