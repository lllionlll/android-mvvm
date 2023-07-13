package com.example.mysourcebase.data.source.remote.auth

import com.example.mysourcebase.data.source.remote.ApiSuccess
import com.example.mysourcebase.data.source.remote.DataResult
import com.example.mysourcebase.data.source.remote.handleApi
import com.example.mysourcebase.data.source.remote.auth.request.SignInRequest
import com.example.mysourcebase.data.source.remote.auth.response.SignInResponse
import javax.inject.Inject

interface AuthApiHelper {

    suspend fun login(signInRequest: SignInRequest): DataResult<SignInResponse>

}

class AuthApiHelperImpl @Inject constructor(private val authApiService: AuthApiService) :
    AuthApiHelper {
    override suspend fun login(signInRequest: SignInRequest): DataResult<SignInResponse> {
        return try {
            when (val response = handleApi { authApiService.login(signInRequest) }) {
                is ApiSuccess -> {
                    DataResult.Success(response.data.data)
                }

                else -> {
                    DataResult.Error()
                }
            }
        } catch (e: Exception) {
            DataResult.Error(e)
        }

    }

}