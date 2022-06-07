package com.example.navigation.data

import android.content.Context
import androidx.core.content.edit
import com.example.navigation.data.converters.UserToUserNameConverter
import com.example.navigation.data.storage.SharedPrefUserStorage
import com.example.navigation.data.storage.UserStorage
import com.example.navigation.domain.UserParamToUserConverter
import com.example.navigation.domain.models.UserName
import com.example.navigation.domain.models.UserNameParam
import com.example.navigation.domain.repository.UserRepository

class UserRepositorylmpl(
    private val userStorage: UserStorage,
    private val userParamToUserConverter: UserParamToUserConverter,
    private val userToUserNameConverter: UserToUserNameConverter
) : UserRepository {

    override fun saveUserParam(userParam: UserNameParam): Boolean {
        return userStorage.saveUserParam(userParamToUserConverter.invoke(userParam))
    }

    override fun getUserName(): UserName {

        return userToUserNameConverter.invoke(userStorage.getUserName())
    }

}