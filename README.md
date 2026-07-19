# 📱 Ktor Login Android

A modern Android application built with **Kotlin** and **Jetpack Compose** that integrates with a **Ktor Login API** backend using REST APIs and JWT-based authentication.

This project demonstrates Android frontend development, API integration, asynchronous networking using Kotlin Coroutines, and a clean project structure following MVVM principles.

---

## 🚀 Features

- 🔐 User Login Authentication
- 🌐 REST API Integration with Ktor Backend
- 📱 Modern UI using Jetpack Compose
- ⚡ Asynchronous Networking with Kotlin Coroutines
- 🔄 JSON Serialization & Deserialization
- 🏗️ MVVM Architecture
- 🧩 Repository Pattern
- 📡 Ktor Client Integration
- 🔑 JWT Authentication Support
- 🚪 Logout Functionality
- 📲 Real Device Testing

---

## 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| Kotlin | Programming Language |
| Jetpack Compose | Android UI Toolkit |
| Ktor Client | HTTP Client |
| Kotlin Coroutines | Asynchronous Programming |
| Kotlinx Serialization | JSON Parsing |
| Material 3 | UI Components |
| Android Studio | IDE |
| Git & GitHub | Version Control |

---

## 📂 Project Structure

```
app/
│
├── api/
│   ├── ApiService.kt
│   └── KtorClient.kt
│
├── model/
│   ├── LoginRequest.kt
│   ├── LoginResponse.kt
│   └── User.kt
│
├── repository/
│   └── LoginRepository.kt
│
├── ui/
│   ├── LoginScreen.kt
│   └── HomeScreen.kt
│
├── viewmodel/
│   └── LoginViewModel.kt
│
└── MainActivity.kt
```

---

## 📱 Application Workflow

```
User
   │
   ▼
Login Screen
   │
   ▼
Enter Email & Password
   │
   ▼
POST /login
(Ktor Client)
   │
   ▼
Ktor Login API
   │
   ▼
JWT Authentication
   │
   ▼
Login Success
   │
   ▼
Home Screen
```

---

## 🔗 Backend API

This Android application communicates with a Kotlin Ktor backend.

### Login Endpoint

```
POST /login
```

### Example Request

```json
{
  "email": "user@gmail.com",
  "password": "password123"
}
```

---

## 🏛️ Architecture

This project follows the **MVVM (Model–View–ViewModel)** architecture.

```
UI
│
▼
ViewModel
│
▼
Repository
│
▼
ApiService
│
▼
Ktor Client
│
▼
Ktor Backend
```

---

## ▶️ Getting Started

### Clone Repository

```bash
git clone https://github.com/THILAK0520/KtorLoginAndroid.git
```

### Open Project

Open the project using **Android Studio**.

### Run

- Connect an Android device or emulator.
- Ensure the Ktor backend is running.
- Update the backend IP address in `ApiService.kt` if required.
- Run the application.

---

## 📚 Skills Demonstrated

- Android Development
- Kotlin
- Jetpack Compose
- MVVM Architecture
- Repository Pattern
- REST API Integration
- Ktor Client
- JWT Authentication
- Coroutines
- JSON Serialization
- Git & GitHub

---

## 🔮 Future Enhancements

- Secure JWT Token Storage
- Refresh Token Support
- Persistent User Session
- Retrofit Alternative Implementation
- Dark Mode
- Unit Testing
- UI Testing
- Dependency Injection (Hilt)
- Navigation Compose
- Error Handling Improvements

---

## 👨‍💻 Author

**Thilak Kumar N**

- GitHub: https://github.com/THILAK0520

---

## 📄 License

This project is intended for educational and portfolio purposes.

## Related Project

### Backend Repository
https://github.com/THILAK0520/KtorLoginAPI

### Android Frontend Repository
https://github.com/THILAK0520/KtorLoginAndroid
