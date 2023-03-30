package com.example.androidfeatures.di

import com.example.navigation.Navigator
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideNavigator(): Navigator = Navigator()
}