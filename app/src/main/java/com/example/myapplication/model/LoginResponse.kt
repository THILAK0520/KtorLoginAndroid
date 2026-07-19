package com.example.myapplication.model

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val message:String,
    val accesToken:String? = null,
    val refreshToken: String?= null
)
