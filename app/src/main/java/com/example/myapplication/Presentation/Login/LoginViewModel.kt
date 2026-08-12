package com.example.myapplication.Presentation.Login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.Domain.Repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: AuthRepository
) : ViewModel() {

    private val _loginState = MutableStateFlow("")
    val loginState: StateFlow<String> = _loginState

    fun login(
        email: String,
        password: String
    ) {

        println("LOGIN BUTTON -> email=$email")

        viewModelScope.launch {

            val result = repository.login(
                email = email,
                password = password
            )

            result.onSuccess {
                _loginState.value = "Login successful"
            }

            result.onFailure { exception ->
                _loginState.value =
                    exception.message ?: "Login failed"
            }
        }
    }
}