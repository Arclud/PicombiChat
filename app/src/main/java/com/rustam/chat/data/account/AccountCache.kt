package com.rustam.chat.data.account

import com.rustam.chat.domain.type.None
import com.rustam.chat.domain.type.exception.Failure
import com.rustam.chat.domain.type.Either

interface AccountCache {
    fun getToken(): Either<Failure, String>
    fun saveToken(token: String): Either<Failure, None>
}