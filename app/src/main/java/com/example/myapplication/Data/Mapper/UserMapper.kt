package com.example.myapplication.Data.Mapper

import com.example.myapplication.Data.Remote.DTO.Response.UserResponse
import com.example.myapplication.Domain.Model.User

fun UserResponse.toDomain(): User {

    return User(
        id =id,
        name = name,
        email = email,
        role= role
    )
}