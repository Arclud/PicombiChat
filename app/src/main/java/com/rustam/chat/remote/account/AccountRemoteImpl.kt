package com.rustam.chat.remote.account

import com.rustam.chat.data.account.AccountRemote
import com.rustam.chat.domain.type.Either
import com.rustam.chat.domain.type.None
import com.rustam.chat.domain.type.exception.Failure
import com.rustam.chat.remote.service.ApiService
import com.rustam.chat.remote.core.Request
import javax.inject.Inject

class AccountRemoteImpl @Inject constructor(
    private val request: Request,
    private val service: ApiService
) : AccountRemote {

    override fun register(
        email: String,
        name: String,
        password: String,
        token: String,
        userDate: Long
    ): Either<Failure, None> {
        return request.make(
            service.register(
                createRegisterMap(
                    email,
                    name,
                    password,
                    token,
                    userDate
                )
            )
        ) { None() }
    }

    private fun createRegisterMap(
        email: String,
        name: String,
        password: String,
        token: String,
        userDate: Long
    ): Map<String, String> {
        val map = HashMap<String, String>()
        map[ApiService.PARAM_EMAIL] = email
        map[ApiService.PARAM_NAME] = name
        map[ApiService.PARAM_PASSWORD] = password
        map[ApiService.PARAM_TOKEN] = token
        map[ApiService.PARAM_USER_DATE] = userDate.toString()
        return map
    }
}