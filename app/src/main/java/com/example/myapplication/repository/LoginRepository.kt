package com.example.myapplication.repository

import com.example.myapplication.api.ApiService
import com.example.myapplication.model.LoginRequest
import com.example.myapplication.model.LoginResponse

class LoginRepository {

    private val apiService = ApiService()

    suspend fun login(email:String, password:String):Result<LoginResponse>{
        return try{
            val response = apiService.login(LoginRequest(email = email, password =password))

            Result.success(response)
        }catch (exception :Exception){
            Result.failure(exception)
        }
    }
}