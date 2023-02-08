package com.example.androidfeatures.di

import android.app.Application

class AndroidFeaturesApplication : Application() {

    private val androidFeaturesApplicationComponent: AndroidFeaturesApplicationComponent by lazy {
        AndroidFeaturesApplicationComponent(this)
    }

    override fun onCreate() {
        super.onCreate()

        androidFeaturesApplicationComponent.inject(this)
    }
}