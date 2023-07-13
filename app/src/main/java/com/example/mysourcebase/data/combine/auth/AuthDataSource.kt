package com.example.mysourcebase.data.combine.auth

import com.example.mysourcebase.data.source.remote.DataResult
import com.example.mysourcebase.data.source.remote.auth.request.SignInRequest
import com.example.mysourcebase.data.source.remote.auth.response.SignInResponse

interface AuthDataSource {
    suspend fun signIn(signInRequest: SignInRequest): DataResult<SignInResponse>
}