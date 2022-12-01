package com.example.androidfeatures.di

import android.app.Application
import com.example.navigation.NavigationDependencies
import com.example.navigation.NavigationDepsProvider

class AndroidFeaturesApplication : Application(), NavigationDepsProvider {

    private val androidFeaturesApplicationComponent: AndroidFeaturesApplicationComponent by lazy {
        AndroidFeaturesApplicationComponent(this)
    }

    override fun onCreate() {
        super.onCreate()

        androidFeaturesApplicationComponent.inject(this)
    }

    override val deps: NavigationDependencies = androidFeaturesApplicationComponent
}