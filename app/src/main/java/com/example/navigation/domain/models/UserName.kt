package com.example.navigation.domain.models

data class UserName (
    val firstName: String,
    val secondName: String,
)

data class UserNameParam(val name: String)