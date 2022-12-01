package com.example.marvelapp.presentation.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.rafael.core.usecase.GetCharactersUseCase
import kotlinx.coroutines.flow.Flow
import com.rafael.core.domain.model.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
): ViewModel( ){

    fun characterPagingData(query: String): Flow<PagingData<Character>>{
        return getCharactersUseCase(
            GetCharactersUseCase.GetCharactersParams(query, getPageConfig())
        ).cachedIn(viewModelScope)
    }

    private fun getPageConfig() = PagingConfig(
        pageSize = 20
    )
}