package com.example.mysourcebase.data.repository.auth

import com.example.mysourcebase.data.source.remote.DataResult
import com.example.mysourcebase.data.source.remote.auth.request.SignInRequest
import com.example.mysourcebase.data.source.remote.auth.response.SignInResponse

interface AuthRepository {

    suspend fun signIn(
        signInRequest: SignInRequest = SignInRequest()
    ): DataResult<SignInResponse>

}