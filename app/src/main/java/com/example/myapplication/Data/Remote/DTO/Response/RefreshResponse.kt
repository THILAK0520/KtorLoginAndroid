package com.example.myapplication.Data.Remote.DTO.Response

import kotlinx.serialization.Serializable

@Serializable
data class RefreshResponse(

    val accessToken: String
)
