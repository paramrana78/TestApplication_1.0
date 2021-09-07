package com.assign.srijan

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine

class ValidationViewmodel : ViewModel() {

    private val _firstName = MutableStateFlow("")
    private val _password = MutableStateFlow("")

    fun setFirstName(name: String) {
        _firstName.value = name
    }


    fun setPassword(password: String) {
        _password.value = password
    }

    val isSubmitEnabled: Flow<Boolean> = combine(_firstName, _password) { firstName, password ->
            val regexString = "[a-zA-Z0-9]+"
            val isNameCorrect = firstName.matches(regexString.toRegex())
            val isPasswordCorrect = password.length >= 8

            return@combine isNameCorrect and isPasswordCorrect
        }
}