package com.example.myapplication.Data.Remote.DTO.Request

import kotlinx.serialization.Serializable


@Serializable
data class RefreshRequest(
    val refreshToken: String
)
