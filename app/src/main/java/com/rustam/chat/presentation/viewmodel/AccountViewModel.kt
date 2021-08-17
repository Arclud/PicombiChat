package com.rustam.chat.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.rustam.chat.domain.account.Register
import com.rustam.chat.domain.type.None
import javax.inject.Inject

class AccountViewModel @Inject constructor(
    val registerUseCase: Register
) : BaseViewModel() {

    val registerData: MutableLiveData<None> = MutableLiveData()

    fun register(email: String, name: String, password: String) {
        registerUseCase(Register.Params(email, name, password)) {
            it.either(::handleFailure, ::handleRegister)
        }
    }

    fun handleRegister(none: None) {
        this.registerData.value = none
    }

    override fun onCleared() {
        super.onCleared()
        registerUseCase.unsubscribe()
    }
}