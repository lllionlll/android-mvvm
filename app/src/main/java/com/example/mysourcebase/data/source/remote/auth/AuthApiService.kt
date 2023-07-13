package com.example.mysourcebase.data.source.remote.auth

import com.example.mysourcebase.data.source.remote.ApiResponse
import com.example.mysourcebase.data.source.remote.auth.request.SignInRequest
import com.example.mysourcebase.data.source.remote.auth.response.SignInResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface AuthApiService {

    @POST("/api/login")
    suspend fun login(@Body signInRequest: SignInRequest): Response<ApiResponse<SignInResponse>>

}
