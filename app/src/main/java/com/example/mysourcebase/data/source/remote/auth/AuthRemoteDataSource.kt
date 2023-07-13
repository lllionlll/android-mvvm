package com.example.mysourcebase.data.source.remote.auth

import com.example.mysourcebase.data.combine.auth.AuthDataSource
import com.example.mysourcebase.data.source.remote.DataResult
import com.example.mysourcebase.data.source.remote.auth.request.SignInRequest
import com.example.mysourcebase.data.source.remote.auth.response.SignInResponse
import javax.inject.Inject

class AuthRemoteDataSource @Inject constructor(
    private val authApiHelper: AuthApiHelper
) : AuthDataSource {
    override suspend fun signIn(signInRequest: SignInRequest): DataResult<SignInResponse> {
        return authApiHelper.login(signInRequest)
    }

}