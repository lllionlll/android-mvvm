package com.example.mysourcebase.di

import android.content.Context
import androidx.room.Room
import com.example.mysourcebase.data.combine.auth.AuthDataSource
import com.example.mysourcebase.data.repository.auth.AuthRepository
import com.example.mysourcebase.data.repository.auth.DefaultAuthRepository
import com.example.mysourcebase.data.source.local.MyDatabase
import com.example.mysourcebase.data.source.local.auth.AuthLocalDataSource
import com.example.mysourcebase.data.source.remote.auth.AuthApiHelperImpl
import com.example.mysourcebase.data.source.remote.auth.AuthRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class RemoteAuthDataSource

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class LocalAuthDataSource

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideAuthRepository(
        @LocalAuthDataSource authLocalDataSource: AuthDataSource,
        @RemoteAuthDataSource remoteDataSource: AuthDataSource,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): AuthRepository {
        return DefaultAuthRepository(
            authLocalDataSource,
            remoteDataSource,
            ioDispatcher
        )
    }

}

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    @LocalAuthDataSource
    fun provideAuthLocalDataSource(
        database: MyDatabase
    ): AuthDataSource {
        return AuthLocalDataSource(database.authDao())
    }

    @Singleton
    @Provides
    @RemoteAuthDataSource
    fun provideAuthRemoteDataSource(
        authApiHelperImpl: AuthApiHelperImpl
    ): AuthDataSource {
        return AuthRemoteDataSource(authApiHelperImpl)
    }
}

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): MyDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            MyDatabase::class.java,
            "my_db.db"
        ).build()
    }
}