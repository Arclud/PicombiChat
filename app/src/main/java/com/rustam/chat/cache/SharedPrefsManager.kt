package com.rustam.chat.cache

import android.content.SharedPreferences
import com.rustam.chat.domain.type.None
import com.rustam.chat.domain.type.exception.Failure
import com.rustam.chat.domain.type.Either
import javax.inject.Inject

class SharedPrefsManager @Inject constructor(private val prefs: SharedPreferences) {
    companion object {
        const val ACCOUNT_TOKEN = "account_token"
    }

    fun saveToken(token: String): Either<Failure, None> {
        prefs.edit().apply {
            putString(ACCOUNT_TOKEN, token)
        }.apply()

        return Either.Right(None())
    }

    fun getToken(): Either<Failure, String> {
        return Either.Right(prefs.getString(ACCOUNT_TOKEN, "").toString())
    }
}