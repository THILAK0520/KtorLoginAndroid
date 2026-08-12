package com.example.myapplication.di

import com.example.myapplication.Core.Network.KtorClient
import com.example.myapplication.Data.Local.TokenManager
import com.example.myapplication.Data.Remote.Api.AuthApiService
import com.example.myapplication.Data.Repository.AuthRepositoryImpl
import com.example.myapplication.Domain.Repository.AuthRepository
import com.example.myapplication.Presentation.Login.LoginViewModel
import com.example.myapplication.Presentation.Register.RegisterViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModule {

    val appModule = module {

        single<TokenManager> {
            TokenManager(
                context = androidContext()
            )
        }

        single {
            KtorClient.create(
                tokenManager = get()
            )
        }

        single {
            AuthApiService(
                client = get()
            )
        }

        single<AuthRepository> {
            AuthRepositoryImpl(
                apiService = get(),
                tokenManager = get()
            )
        }

        viewModel {
            LoginViewModel(
                repository = get()
            )
        }

        viewModel {
            RegisterViewModel(
                repository = get()
            )
        }
    }
}