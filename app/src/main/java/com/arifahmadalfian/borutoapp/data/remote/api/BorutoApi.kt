package com.arifahmadalfian.borutoapp.data.remote.api

import com.arifahmadalfian.borutoapp.domain.model.ApiResponse
import com.arifahmadalfian.borutoapp.domain.model.Hero
import retrofit2.http.GET
import retrofit2.http.Query

interface BorutoApi {

    @GET("/boruto/heroes")
    suspend fun getAllHeroes(
        @Query("page") page: Int = 1
    ): ApiResponse<List<Hero>>

    @GET("/boruto/heroes/search")
    suspend fun searchHeroes(
        @Query("name") name: String
    ): ApiResponse<List<Hero>>
}