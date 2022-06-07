package com.example.navigation.domain

import com.example.navigation.data.User
import com.example.navigation.domain.models.UserNameParam

interface Converter<INPUT, OUTPUT> {

    fun invoke(params: INPUT): OUTPUT
}

class UserParamToUserConverter : Converter<UserNameParam, User> {

    override fun invoke(params: UserNameParam): User {
        return User(params.name, "")
    }
}