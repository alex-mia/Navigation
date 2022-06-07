package com.example.navigation.data.storage

import android.content.Context
import androidx.core.content.edit
import com.example.navigation.data.User
import com.example.navigation.data.UserRepositorylmpl
import com.example.navigation.domain.models.UserName
import com.example.navigation.domain.models.UserNameParam

class SharedPrefUserStorage(context: Context): UserStorage {

    private val sharedPrefUserStorage =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveUserParam(user: User): Boolean {
        sharedPrefUserStorage.edit { putString(FIRST_NAME_KEY, user.firstName) }
        sharedPrefUserStorage.edit(){ putString(SECOND_NAME_KEY, user.secondName)}
        return true
    }

    override fun getUserName(): User {
        val firstName = sharedPrefUserStorage.getString(
            FIRST_NAME_KEY,
            EMPTY_STRING
        ) ?: EMPTY_STRING
        val secondName =
            sharedPrefUserStorage.getString(
                SECOND_NAME_KEY,
                DEFAULT_VALUE
            ) ?: DEFAULT_VALUE
        return User(
            firstName = firstName,
            secondName = secondName
        )
    }

    companion object {
        private const val SHARED_PREFS_NAME = "SHARED_PREFS_NAME"
        private const val FIRST_NAME_KEY = "FIRST_NAME_KEY"
        private const val SECOND_NAME_KEY = "SECOND_NAME_KEY"
        private const val DEFAULT_VALUE = "default value"
        private const val EMPTY_STRING = ""
    }
}