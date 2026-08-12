package com.example.myapplication.Presentation.Register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.Domain.Repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val repository: AuthRepository
) : ViewModel() {

    private val _registerState = MutableStateFlow("")
    val registerState: StateFlow<String> = _registerState

    fun register(
        name: String,
        email: String,
        password: String
    ) {
        viewModelScope.launch {

            val result = repository.register(
                name = name,
                email = email,
                password = password
            )

            result.onSuccess { response ->
                _registerState.value = response
            }

            result.onFailure { exception ->
                _registerState.value =
                    exception.message ?: "Registration failed"
            }
        }
    }
}