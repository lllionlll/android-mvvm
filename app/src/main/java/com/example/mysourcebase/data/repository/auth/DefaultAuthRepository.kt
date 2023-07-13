package com.example.mysourcebase.data.repository.auth

import com.example.mysourcebase.data.combine.auth.AuthDataSource
import com.example.mysourcebase.data.source.remote.DataResult
import com.example.mysourcebase.data.source.remote.auth.request.SignInRequest
import com.example.mysourcebase.data.source.remote.auth.response.SignInResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultAuthRepository @Inject constructor(
    private val authLocalDataSource: AuthDataSource,
    private val authRemoteDataSource: AuthDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : AuthRepository {
    override suspend fun signIn(signInRequest: SignInRequest): DataResult<SignInResponse> {
        return withContext(ioDispatcher) {
            val authRemoteDataSourceResult = authRemoteDataSource.signIn(
                signInRequest
            )
            if (authRemoteDataSourceResult is DataResult.Success) {
                val authDataSourceData = authRemoteDataSourceResult.data
                return@withContext DataResult.Success(authDataSourceData)
            }
            return@withContext DataResult.Error()
        }
    }


}