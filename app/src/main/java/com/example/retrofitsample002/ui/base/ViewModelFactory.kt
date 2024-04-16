package com.example.retrofitsample002.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitsample002.data.api.ApiHelper
import com.example.retrofitsample002.data.repository.HomeRepository
import com.example.retrofitsample002.ui.homeScreen.viewmodel.HomeViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val apiHelper: ApiHelper): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(HomeRepository(this.apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}