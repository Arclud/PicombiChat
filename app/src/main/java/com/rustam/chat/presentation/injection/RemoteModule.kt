package com.rustam.chat.presentation.injection

import com.andreabaccega.formedittext.BuildConfig
import com.rustam.chat.data.account.AccountRemote
import com.rustam.chat.remote.account.AccountRemoteImpl
import com.rustam.chat.remote.core.Request
import com.rustam.chat.remote.service.ApiService
import com.rustam.chat.remote.service.ServiceFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteModule {

    @Singleton
    @Provides
    fun provideApiService(): ApiService = ServiceFactory.makeService(BuildConfig.DEBUG)

    @Singleton
    @Provides
    fun provideAccountRemote(request: Request, apiService: ApiService): AccountRemote {
        return AccountRemoteImpl(request, apiService)

    }
}