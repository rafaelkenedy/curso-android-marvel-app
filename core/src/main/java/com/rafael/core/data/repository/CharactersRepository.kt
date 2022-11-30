package com.rafael.core.data.repository

import androidx.paging.PagingSource
import com.rafael.core.domain.model.Character

interface CharactersRepository {

    fun getCharacter(query: String): PagingSource<Int, Character>
}