package com.rustam.chat.domain.account

import com.rustam.chat.domain.interactor.UseCase
import com.rustam.chat.domain.type.None
import javax.inject.Inject

class UpdateToken @Inject constructor(
        private val accountRepository: AccountRepository
) : UseCase<None, UpdateToken.Params>() {

    override suspend fun run(params: Params) = accountRepository.updateAccountToken(params.token)

    data class Params(val token: String)
}