package com.epam.bankinggenerativeai.authentication

import com.epam.bankinggenerativeai.authentication.data.repositories.AuthRepositoryImpl
import com.epam.bankinggenerativeai.authentication.domain.repositories.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//object AuthModule {
//
//    @Provides
//    @Singleton
//    fun provideAuthRepository(
//        localAuthDataSource: LocalAuthDataSource,
//        remoteAuthDataSource: RemoteAuthDataSource
//    ): AuthRepository {
//        return AuthRepositoryImpl(remoteAuthDataSource, localAuthDataSource)
//    }
//}

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthModule {

    @Binds
    @Singleton
    abstract fun bindRemoteAuthDataSource(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository
}