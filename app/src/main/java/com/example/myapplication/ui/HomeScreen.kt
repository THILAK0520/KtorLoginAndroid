package com.example.myapplication.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun HomeScreen(
    onLogout: () -> Unit
) {
    var statusMessage by remember {
        mutableStateOf("Login successful. Homepage opened.")
    }

    var remainingSeconds by remember {
        mutableStateOf(60)
    }

    LaunchedEffect(Unit) {

        while (remainingSeconds > 0) {
            delay(1000)
            remainingSeconds = remainingSeconds - 1
        }
    }

    LaunchedEffect(Unit) {

        delay(30_000)

        statusMessage = "30 seconds completed - GET /user"

        delay(30_000)

        statusMessage = "60 seconds completed - GET /users"

        delay(500)

        onLogout()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "Home Page")

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(text = statusMessage)

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Text(
            text = "Automatic logout in $remainingSeconds seconds"
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = {
                onLogout()
            }
        ) {
            Text(text = "LOGOUT")
        }
    }
}