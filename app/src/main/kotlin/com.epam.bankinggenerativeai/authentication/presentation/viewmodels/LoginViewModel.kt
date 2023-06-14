package com.epam.bankinggenerativeai.authentication.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.epam.bankinggenerativeai.authentication.domain.entities.User
import com.epam.bankinggenerativeai.authentication.domain.usecases.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class LoginState {
    object Initial : LoginState()
    object Loading : LoginState()
    data class Success(val user: User) : LoginState()
    data class Error(val message: String) : LoginState()
}

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {

    private val _loginResult = MutableStateFlow<LoginState>(LoginState.Initial)
    val loginResult: StateFlow<LoginState> = _loginResult

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loginResult.value = LoginState.Loading
            try {
                val user = loginUseCase.execute(LoginUseCase.Params(email, password))
                if (user != null) {
                    _loginResult.value = LoginState.Success(user)
                } else {
                    _loginResult.value = LoginState.Error("Login failed")
                }
            } catch (e: Exception) {
                _loginResult.value = LoginState.Error(e.message ?: "An error occurred")
            }
        }
    }
}