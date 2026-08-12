package com.example.myapplication.Core.Network

import android.content.Context
import com.example.myapplication.Data.Local.TokenManager
import com.example.myapplication.Data.Remote.Api.AuthApiService

object NetworkModule {

    fun provideTokenManager(
        context: Context
    ): TokenManager {
        return TokenManager(context)
    }

    fun provideAuthApiService(
        tokenManager: TokenManager
    ): AuthApiService {
        return AuthApiService(
            client = KtorClient.create(tokenManager)
        )
    }
}