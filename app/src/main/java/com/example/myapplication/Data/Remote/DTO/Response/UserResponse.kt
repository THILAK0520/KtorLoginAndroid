package com.example.myapplication.Data.Remote.DTO.Response

import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val id: Int,
    val name: String,
    val email:String,
    val role:String
)
