package com.example.myapplication.Data.Repository

import com.example.myapplication.Data.Local.TokenManager
import com.example.myapplication.Data.Mapper.toDomain
import com.example.myapplication.Data.Remote.Api.AuthApiService
import com.example.myapplication.Data.Remote.DTO.Request.LoginRequest
import com.example.myapplication.Data.Remote.DTO.Request.RefreshRequest
import com.example.myapplication.Data.Remote.DTO.Request.RegisterRequest
import com.example.myapplication.Domain.Model.Token
import com.example.myapplication.Domain.Model.User
import com.example.myapplication.Domain.Repository.AuthRepository
import kotlinx.coroutines.flow.first

class AuthRepositoryImpl(
    private val apiService: AuthApiService,
    private val tokenManager: TokenManager
) : AuthRepository {

    override suspend fun register(
        name: String,
        email: String,
        password: String
    ): Result<String> = runCatching {

        apiService.register(
            RegisterRequest(
                name = name,
                email = email,
                password = password
            )
        )
    }

    override suspend fun login(
        email: String,
        password: String
    ): Result<Token> = runCatching {

        val response = apiService.login(
            LoginRequest(
                email = email,
                password = password
            )
        )

        tokenManager.saveTokens(
            accessToken = response.accessToken,
            refreshToken = response.refreshToken
        )

        Token(
            accessToken = response.accessToken,
            refreshToken = response.refreshToken
        )
    }

    override suspend fun getUser(): Result<User> = runCatching {

        apiService.getUser().toDomain()
    }

    override suspend fun refreshToken(
        refreshToken: String
    ): Result<Token> = runCatching {

        val response = apiService.refreshToken(
            RefreshRequest(
                refreshToken = refreshToken
            )
        )

        tokenManager.saveAccessToken(
            response.accessToken
        )

        Token(
            accessToken = response.accessToken,
            refreshToken = refreshToken
        )
    }

    override suspend fun logout(): Result<String> = runCatching {

        val response = apiService.logout()

        tokenManager.clearToken()

        response
    }
}