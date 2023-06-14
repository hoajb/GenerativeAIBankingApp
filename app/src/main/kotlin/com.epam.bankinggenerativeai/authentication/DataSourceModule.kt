package com.epam.bankinggenerativeai.authentication

import com.epam.bankinggenerativeai.authentication.data.datasources.LocalAuthDataSource
import com.epam.bankinggenerativeai.authentication.data.datasources.LocalAuthDataSourceImpl
import com.epam.bankinggenerativeai.authentication.data.datasources.RemoteAuthDataSource
import com.epam.bankinggenerativeai.authentication.data.datasources.RemoteAuthDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindLocalAuthDataSource(
        localAuthDataSourceImpl: LocalAuthDataSourceImpl
    ): LocalAuthDataSource

    @Binds
    @Singleton
    abstract fun bindRemoteAuthDataSource(
        remoteAuthDataSourceImpl: RemoteAuthDataSourceImpl
    ): RemoteAuthDataSource
}