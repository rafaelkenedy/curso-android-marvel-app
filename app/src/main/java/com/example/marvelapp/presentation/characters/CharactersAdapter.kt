package com.example.marvelapp.presentation.characters

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.rafael.core.domain.model.Character

class CharactersAdapter : PagingDataAdapter<Character, CharacetersViewHolder>(diffCallBack) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacetersViewHolder {
        return CharacetersViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: CharacetersViewHolder, position: Int) {
        getItem(position)?.let { character ->
            holder.bind(character)
        }
    }

    companion object {
        private val diffCallBack = object : DiffUtil.ItemCallback<Character>() {
            override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem == newItem
            }
        }
    }
}