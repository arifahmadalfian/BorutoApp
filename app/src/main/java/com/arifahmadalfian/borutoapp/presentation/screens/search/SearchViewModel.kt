package com.arifahmadalfian.borutoapp.presentation.screens.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.arifahmadalfian.borutoapp.domain.model.Hero
import com.arifahmadalfian.borutoapp.domain.use_case.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {
    private val _searchQuery = mutableStateOf("")
    val searchQuery = _searchQuery

    private val _searchHeroes = MutableStateFlow<PagingData<Hero>>(PagingData.empty())
    val searchHeroes = _searchHeroes

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
        if (query.length > 2) {
            searchHeroes(query = searchQuery.value)
        }
    }

    fun searchHeroes(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.searchHeroesUseCase(query = query).cachedIn(viewModelScope).collect {
                _searchHeroes.value = it
            }
        }
    }
}