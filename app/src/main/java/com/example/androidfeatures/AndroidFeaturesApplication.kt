package com.example.androidfeatures

import android.app.Application
import com.example.androidfeatures.di.AppComponent
import com.example.androidfeatures.di.DaggerAppComponent
import com.example.common.di.AppComponentProvider

class AndroidFeaturesApplication : Application(), AppComponentProvider {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent
            .builder()
            .context(this)
            .build()
            .apply { inject(this@AndroidFeaturesApplication) }
            .also { appComponent = it }
    }

    override fun provideAppComponent(): AppComponent = appComponent
}