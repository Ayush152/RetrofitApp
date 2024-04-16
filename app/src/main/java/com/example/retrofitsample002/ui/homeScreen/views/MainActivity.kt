package com.example.retrofitsample002.ui.homeScreen.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitsample002.databinding.ActivityMainBinding
import com.example.retrofitsample002.data.api.ApiHelper
import com.example.retrofitsample002.data.api.RetrofitBuilder
import com.example.retrofitsample002.data.model.rickAndMorty
import com.example.retrofitsample002.ui.base.ViewModelFactory
import com.example.retrofitsample002.ui.homeScreen.adapter.HomeAdapter
import com.example.retrofitsample002.ui.homeScreen.viewmodel.HomeViewModel
import com.example.retrofitsample002.utils.Status

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var adapter: HomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setupObserver()
        setupAdapter()
    }

    private fun setupAdapter() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = HomeAdapter(arrayListOf())
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerView.context,
                (binding.recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        binding.recyclerView.adapter = adapter
    }

    private fun setupObserver() {
        homeViewModel.getCharacterDetails().observe(this) {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        binding.progressBar.visibility = View.GONE
                        binding.recyclerView.visibility = View.VISIBLE
                        resource.data?.let { it2 -> retreiveList(it2) }
                    }

                    Status.ERROR -> {
                        binding.progressBar.visibility = View.GONE
                        binding.recyclerView.visibility = View.VISIBLE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }

                    Status.LOADING -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.recyclerView.visibility = View.GONE
                    }
                }
            }
        }
    }

    private fun retreiveList(obj: rickAndMorty) {
        adapter.apply {
            addCharacters(obj.results)
            notifyDataSetChanged()
        }
    }

    private fun setupViewModel() {
        homeViewModel = ViewModelProvider(this, ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))).get(
            HomeViewModel::class.java
        )
    }
}