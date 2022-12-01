package com.example.androidfeatures.di

import com.example.navigation.Navigator
import dagger.Module
import dagger.Provides

@Module
class AndroidFeaturesApplicationModule {

    @Provides
    fun provideNavigator(): Navigator = Navigator()
}