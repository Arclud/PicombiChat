package com.rustam.chat.presentation.injection

import android.content.Context
import com.rustam.chat.data.account.AccountCache
import com.rustam.chat.data.account.AccountRemote
import com.rustam.chat.data.account.AccountRepositoryImpl
import com.rustam.chat.domain.account.AccountRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {
    @Provides
    @Singleton
    fun providerAppContext(): Context = context

    @Provides
    @Singleton
    fun providerAccountRepository(remote: AccountRemote, cache: AccountCache): AccountRepository {
        return AccountRepositoryImpl(remote,cache)
    }

}