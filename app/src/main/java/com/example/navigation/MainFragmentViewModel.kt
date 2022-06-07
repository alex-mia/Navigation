package com.example.navigation


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.navigation.domain.base.GetUserNameUseCase
import com.example.navigation.domain.base.SaveUserNameUseCase
import com.example.navigation.domain.models.UserNameParam

class MainFragmentViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private val _resultLiveData = MutableLiveData<String>()
    val resultLiveData: LiveData<String> = _resultLiveData

    init {
        println("MainFragmentViewModel created")
    }

    fun save(userName: String) {
        val result = saveUserNameUseCase.execute(UserNameParam(userName))
        _resultLiveData.value = result.toString()
    }

    fun load() {
        val userName = getUserNameUseCase.execute()
        _resultLiveData.value = userName.firstName
    }

    override fun onCleared() {
        println("MainFragmentViewModel cleared")
        super.onCleared()
    }
}
