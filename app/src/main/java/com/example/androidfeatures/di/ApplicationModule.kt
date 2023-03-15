package com.example.androidfeatures.di

import android.content.Context
import com.example.navigation.Navigator
import com.example.utils.ResourceProvider
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    fun provideNavigator(): Navigator = Navigator()

    @Provides
    fun provideResourceProvider(context: Context): ResourceProvider = ResourceProvider(context)
}