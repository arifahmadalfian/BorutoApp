package com.arifahmadalfian.borutoapp.presentation.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.arifahmadalfian.borutoapp.presentation.common.ListContent
import com.arifahmadalfian.borutoapp.presentation.components.RatingWidget
import com.arifahmadalfian.borutoapp.ui.theme.LARGE_PADDING

@ExperimentalCoilApi
@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val allHeroes = homeViewModel.getAllHeroes.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            HomeTopBar(onSearchClick = {})
        },
        content = {
            ListContent(
                heroes = allHeroes,
                navController = navController
            )
        }
    )
}