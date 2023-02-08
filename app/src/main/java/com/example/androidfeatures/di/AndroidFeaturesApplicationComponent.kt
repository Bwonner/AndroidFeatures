package com.example.androidfeatures.di

import android.app.Application
import android.content.Context
import androidx.navigation.NavController
import com.example.androidfeatures.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidFeaturesApplicationModule::class])
interface AndroidFeaturesApplicationComponent {

    fun inject(application: Application)
    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AndroidFeaturesApplicationComponent
    }

    companion object {
        operator fun invoke(context: Context): AndroidFeaturesApplicationComponent =
            DaggerAndroidFeaturesApplicationComponent.factory().create(context)
    }
}