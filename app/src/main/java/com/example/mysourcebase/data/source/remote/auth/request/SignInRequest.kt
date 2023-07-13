package com.example.mysourcebase.data.source.remote.auth.request

data class SignInRequest(
    private val email: String = "",
    private val password: String = "",
)
