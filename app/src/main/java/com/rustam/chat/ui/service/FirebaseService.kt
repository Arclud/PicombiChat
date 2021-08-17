package com.rustam.chat.ui.service

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.rustam.chat.domain.account.UpdateToken
import com.rustam.chat.ui.App
import javax.inject.Inject

class FirebaseService : FirebaseMessagingService() {

    @Inject
    lateinit var updateToken: UpdateToken

    override fun onCreate() {
        super.onCreate()
        App.appComponent.inject(this)
    }

    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)
    }

    override fun onNewToken(token: String) {
        Log.e("fb token", ": $token")
        updateToken(UpdateToken.Params(token))
    }
}
