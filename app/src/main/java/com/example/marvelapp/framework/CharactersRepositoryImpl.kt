package com.example.marvelapp.framework

import androidx.paging.PagingSource
import com.example.marvelapp.framework.network.response.DataWrapperResponse
import com.example.marvelapp.framework.paging.CharactersPagingSource
import com.rafael.core.data.repository.CharactersRemoteDataSource
import com.rafael.core.data.repository.CharactersRepository
import com.rafael.core.domain.model.Character
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(
    private val remoteDataSource: CharactersRemoteDataSource<DataWrapperResponse>
) : CharactersRepository {

    override fun getCharacter(query: String): PagingSource<Int, Character> {
        return CharactersPagingSource(remoteDataSource, query)
    }
}