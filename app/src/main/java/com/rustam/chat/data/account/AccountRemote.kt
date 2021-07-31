package com.rustam.chat.data.account

import com.rustam.chat.domain.type.None
import com.rustam.chat.domain.type.exception.Failure
import com.rustam.chat.domain.type.Either

interface AccountRemote {
    fun register(
            email: String,
            name: String,
            password: String,
            token: String,
            userDate: Long
    ): Either<Failure, None>
}