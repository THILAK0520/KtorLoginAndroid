package com.example.myapplication.Domain.Model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int,
    val name:String,
    val email:String,
    val role:String

)