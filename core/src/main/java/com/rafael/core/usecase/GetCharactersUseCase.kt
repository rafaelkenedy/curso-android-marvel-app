package com.rafael.core.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.rafael.core.data.repository.CharactersRepository
import com.rafael.core.domain.model.Character
import com.rafael.core.usecase.GetCharactersUseCase.GetCharactersParams
import com.rafael.core.usecase.base.PagingUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetCharactersUseCase {
    operator fun invoke(params: GetCharactersParams): Flow<PagingData<Character>>

    data class GetCharactersParams(val query: String, val pagingConfig: PagingConfig)
}

class GetCharactersUseCaseImpl @Inject constructor(
    private val charactersRepository: CharactersRepository
) : PagingUseCase<GetCharactersParams, Character>(),
    GetCharactersUseCase {

    override fun createFlowObservable(params: GetCharactersParams): Flow<PagingData<Character>> {

        val pagingSource = charactersRepository.getCharacter(params.query)
        return Pager(config = params.pagingConfig) {
            pagingSource
        }.flow
    }
}