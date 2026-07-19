package com.example.myapplication.api

import com.example.myapplication.model.LoginRequest
import com.example.myapplication.model.LoginResponse
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class ApiService {

    private val baseUrl = "http://192.168.1.7:8080"

    suspend fun login(request: LoginRequest): LoginResponse {
        return KtorClient.client.post("$baseUrl/login") {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }
}