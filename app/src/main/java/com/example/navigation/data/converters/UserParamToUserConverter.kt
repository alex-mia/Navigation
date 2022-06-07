package com.example.navigation.data.converters

import com.example.navigation.data.User
import com.example.navigation.domain.Converter
import com.example.navigation.domain.models.UserNameParam

class UserParamToUserConverter : Converter<UserNameParam, User> {

    override fun invoke(param: UserNameParam): User{
        return User(param.name, "")
    }
}