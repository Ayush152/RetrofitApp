package com.example.retrofitsample002.ui.homeScreen.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.retrofitsample002.data.model.CharacterDetails
import com.example.retrofitsample002.databinding.ItemCardCharacterBinding

class HomeAdapter(private val characters:ArrayList<CharacterDetails>):
    RecyclerView.Adapter<HomeAdapter.CharacterViewHolder>(){

    inner class CharacterViewHolder(private val binding: ItemCardCharacterBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(character:CharacterDetails){
            binding.apply {
                tvtitle.text = character.name
                tvusername.text = character.species
                tvdatecreated.text = character.date

                Glide.with(tvcolorimage.context).load(character.image).diskCacheStrategy(
                    DiskCacheStrategy.AUTOMATIC
                ).into(tvcolorimage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding =
            ItemCardCharacterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CharacterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(character=characters[position])
    }
    fun addCharacters(characters: List<CharacterDetails>){
        this.characters.apply {
            clear()
            addAll(characters)
        }
    }

}