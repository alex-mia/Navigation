package com.example.navigation.domain.repository

import com.example.navigation.domain.models.UserName
import com.example.navigation.domain.models.UserNameParam

interface UserRepository {
    fun saveUserParam(userParam: UserNameParam): Boolean
    fun getUserName(): UserName
}