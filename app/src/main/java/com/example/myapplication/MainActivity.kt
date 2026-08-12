package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.myapplication.Presentation.Home.HomeScreen
import com.example.myapplication.Presentation.Login.LoginScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {

            var isLoggedIn by remember {
                mutableStateOf(false)
            }

            if (isLoggedIn) {
                HomeScreen(
                    onLogout = {
                        isLoggedIn = false
                    }
                )
            } else {
                LoginScreen(
                    onLoginSuccess = {
                        isLoggedIn = true
                    }
                )
            }
        }
    }
}