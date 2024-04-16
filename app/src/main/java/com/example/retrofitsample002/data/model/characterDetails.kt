package com.example.retrofitsample002.data.model

import com.google.gson.annotations.SerializedName

data class CharacterDetails(
    @SerializedName("created")
    val date: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("species")
    val species: String
)