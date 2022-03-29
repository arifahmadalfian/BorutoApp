package com.arifahmadalfian.borutoapp.domain.use_case.search_heroes

import androidx.paging.PagingData
import com.arifahmadalfian.borutoapp.data.repository.Repository
import com.arifahmadalfian.borutoapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class SearchHeroesUseCases(
    private val repository: Repository
) {
    operator fun invoke(query: String): Flow<PagingData<Hero>> {
        return repository.searchHeroes(query = query)
    }
}