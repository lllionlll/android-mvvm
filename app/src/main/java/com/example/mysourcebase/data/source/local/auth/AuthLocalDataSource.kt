package com.example.mysourcebase.data.source.local.auth

import com.example.mysourcebase.data.source.remote.DataResult
import com.example.mysourcebase.data.combine.auth.AuthDataSource
import com.example.mysourcebase.data.source.remote.auth.request.SignInRequest
import com.example.mysourcebase.data.source.remote.auth.response.SignInResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class AuthLocalDataSource @Inject constructor(
    private val authDao: AuthDao
) : AuthDataSource {

    override suspend fun signIn(signInRequest: SignInRequest): DataResult<SignInResponse> {
        TODO("Not yet implemented")
    }
}