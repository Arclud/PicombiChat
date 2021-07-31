package com.rustam.chat.cache

import com.rustam.chat.data.account.AccountCache
import com.rustam.chat.domain.type.None
import com.rustam.chat.domain.type.exception.Failure
import com.rustam.chat.domain.type.Either
import javax.inject.Inject

class AccountCacheImpl @Inject constructor(private val prefsManager: SharedPrefsManager) : AccountCache {

    override fun saveToken(token: String): Either<Failure, None> {
        return prefsManager.saveToken(token)
    }

    override fun getToken(): Either<Failure, String> {
        return prefsManager.getToken()
    }
}