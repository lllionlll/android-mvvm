package com.example.mysourcebase.ui.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mysourcebase.data.repository.auth.AuthRepository
import com.example.mysourcebase.data.repository.auth.DefaultAuthRepository
import com.example.mysourcebase.data.source.remote.DataResult
import com.example.mysourcebase.data.source.remote.auth.request.SignInRequest
import com.example.mysourcebase.data.source.remote.auth.response.SignInResponse
import com.example.mysourcebase.di.RemoteAuthDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class AuthVM @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    val data: MutableLiveData<SignInResponse?> = MutableLiveData()

    fun signIn() {
        viewModelScope.launch {
            try {
                val authResult =  authRepository.signIn(
                    SignInRequest(
                        email = "nhl.edm@gmail.com",
                        password = "123456"
                    )
                )
                if (authResult is DataResult.Success) {
                    data.value = authResult.data
                }
            } catch (e: Exception) {
                e.message
            }
        }
    }
}