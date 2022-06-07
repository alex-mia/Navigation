package com.example.navigation.domain.base

import UseCase
import com.example.navigation.data.UserRepositorylmpl
import com.example.navigation.domain.models.UserNameParam
import com.example.navigation.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) :
    UseCase<UserNameParam, Boolean> {

    override fun execute(param: UserNameParam?): Boolean {
        return userRepository.saveUserParam(param!!)
    }
}

