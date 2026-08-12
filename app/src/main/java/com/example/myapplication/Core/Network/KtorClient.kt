package com.example.myapplication.Core.Network

import com.example.myapplication.Data.Local.TokenManager
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.first
import kotlinx.serialization.json.Json

object KtorClient {

    fun create(
        tokenManager: TokenManager
    ): HttpClient {

        return HttpClient(Android) {

            install(ContentNegotiation) {

                json(
                    Json {
                        ignoreUnknownKeys = true
                        isLenient = true
                        explicitNulls = false
                    }
                )
            }

            install(Logging) {
                level = LogLevel.BODY
            }

            install(Auth) {

                bearer {

                    loadTokens {

                        val accessToken =
                            tokenManager.accessToken.first()

                        val refreshToken =
                            tokenManager.refreshToken.first()

                        if (
                            !accessToken.isNullOrBlank() &&
                            !refreshToken.isNullOrBlank()
                        ) {
                            BearerTokens(
                                accessToken = accessToken,
                                refreshToken = refreshToken
                            )
                        } else {
                            null
                        }
                    }
                }
            }
        }
    }
}