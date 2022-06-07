package com.example.navigation.domain.base

import UseCase
import com.example.navigation.data.UserRepositorylmpl
import com.example.navigation.domain.models.UserName
import com.example.navigation.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) : UseCase<Unit, UserName> {

    override fun execute(param: Unit?): UserName {
        return userRepository.getUserName()
    }
}