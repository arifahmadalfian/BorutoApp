package com.arifahmadalfian.borutoapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse<T>(
    val success: Boolean,
    val message:String? = null,
    val prevPage: Int? = null,
    val nextPage: Int? = null,
    val heroes: T? = null // always list(see HeroRemoteMediator)
)
