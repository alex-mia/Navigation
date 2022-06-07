package com.example.navigation.data.storage

import com.example.navigation.data.User
import com.example.navigation.domain.models.UserName
import com.example.navigation.domain.models.UserNameParam

interface UserStorage {

    fun saveUserParam (user: User): Boolean

    fun getUserName(): User
}