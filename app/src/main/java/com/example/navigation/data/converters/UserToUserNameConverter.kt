package com.example.navigation.data.converters

import com.example.navigation.data.User
import com.example.navigation.domain.Converter
import com.example.navigation.domain.models.UserName

class UserToUserNameConverter : Converter<User, UserName> {

    override fun invoke(params: User): UserName {
        return UserName(params.firstName, params.secondName)
    }
}