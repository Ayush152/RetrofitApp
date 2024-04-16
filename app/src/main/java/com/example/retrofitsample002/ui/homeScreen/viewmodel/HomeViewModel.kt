package com.example.retrofitsample002.ui.homeScreen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.retrofitsample002.data.repository.HomeRepository
import com.example.retrofitsample002.utils.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {
    fun getCharacterDetails() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        // use launch and async here

        try {
            emit(Resource.success(data = homeRepository.getRickAndMortyObject()))
        } catch(exception:Exception){
            emit(Resource.error(data = null, message = exception.message ?: "ERROR OCCURED"))
        }
    }
}