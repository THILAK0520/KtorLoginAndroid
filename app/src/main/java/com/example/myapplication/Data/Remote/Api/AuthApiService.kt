package com.example.myapplication.Data.Remote.Api

import com.example.myapplication.Core.Util.Constants
import com.example.myapplication.Data.Remote.DTO.Request.LoginRequest
import com.example.myapplication.Data.Remote.DTO.Request.RefreshRequest
import com.example.myapplication.Data.Remote.DTO.Request.RegisterRequest
import com.example.myapplication.Data.Remote.DTO.Response.LoginResponse
import com.example.myapplication.Data.Remote.DTO.Response.RefreshResponse
import com.example.myapplication.Data.Remote.DTO.Response.UserResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody

class AuthApiService(
    private val client: HttpClient
) {

    suspend fun register(
        request: RegisterRequest
    ): String {
        return client.post(
            "${Constants.BASE_URL}${Constants.AUTH_REGISTER}"
        ) {
            setBody(request)
        }.body()
    }

    suspend fun login(
        request: LoginRequest
    ): LoginResponse {
        return client.post(
            "${Constants.BASE_URL}${Constants.AUTH_LOGIN}"
        ) {
            setBody(request)
        }.body()
    }

    suspend fun refreshToken(
        request: RefreshRequest
    ): RefreshResponse {
        return client.post(
            "${Constants.BASE_URL}${Constants.AUTH_REFRESH}"
        ) {
            setBody(request)
        }.body()
    }

    suspend fun getUser(): UserResponse {
        return client.get(
            "${Constants.BASE_URL}${Constants.AUTH_USER}"
        ).body()
    }

    suspend fun home(): String {
        return client.get(
            "${Constants.BASE_URL}${Constants.AUTH_HOME}"
        ).body()
    }

    suspend fun logout(): String {
        return client.post(
            "${Constants.BASE_URL}${Constants.AUTH_LOGOUT}"
        ).body()
    }
}