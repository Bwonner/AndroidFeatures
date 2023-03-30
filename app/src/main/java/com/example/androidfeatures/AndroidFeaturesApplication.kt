package com.example.androidfeatures

import android.app.Application
import com.example.common.di.BaseComponent
import com.example.common.di.BaseComponentProvider
import com.example.common.di.DaggerBaseComponent

class AndroidFeaturesApplication : Application(), BaseComponentProvider {

    lateinit var baseComponent: BaseComponent

    override fun onCreate() {
        super.onCreate()

        baseComponent = DaggerBaseComponent
            .builder()
            .context(this)
            .build()
        baseComponent.inject(this)
    }

    override fun provideBaseComponent(): BaseComponent = baseComponent
}