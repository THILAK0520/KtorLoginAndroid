package com.example.myapplication.Data.Remote.DTO.Request

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val email: String,
    val password: String
)