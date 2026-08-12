package com.example.myapplication.Domain.Repository

import com.example.myapplication.Domain.Model.Token
import com.example.myapplication.Domain.Model.User

interface AuthRepository {

    suspend fun register(
        name: String,
        email: String,
        password: String
    ): Result<String>

    suspend fun login(
        email: String,
        password: String
    ): Result<Token>

    suspend fun refreshToken(
        refreshToken: String
    ): Result<Token>

    suspend fun getUser(): Result<User>

    suspend fun logout(): Result<String>
}