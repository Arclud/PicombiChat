package com.rustam.chat.ui

import android.app.Application
import com.rustam.chat.presentation.injection.AppModule
import com.rustam.chat.presentation.injection.CacheModule
import com.rustam.chat.presentation.injection.RemoteModule
import com.rustam.chat.presentation.injection.ViewModelModule
import com.rustam.chat.ui.activity.RegisterActivity
import com.rustam.chat.ui.fragment.RegisterFragment
import com.rustam.chat.ui.service.FirebaseService
import dagger.Component
import javax.inject.Singleton

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this)).build()
    }
}

@Singleton
@Component(modules = [AppModule::class, CacheModule::class, RemoteModule::class, ViewModelModule::class])
interface AppComponent {

    //activities
    fun inject(activity: RegisterActivity)

    //fragments
    fun inject(fragment: RegisterFragment)

    //services
    fun inject(service: FirebaseService)

}