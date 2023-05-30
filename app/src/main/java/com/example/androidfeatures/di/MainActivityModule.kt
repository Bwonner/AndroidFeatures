package com.example.androidfeatures.di

import com.example.navigation.Navigator
import dagger.Module
import dagger.Provides

@Module
interface MainActivityModule {

    companion object {
        @Provides
        fun provideNavigator(): Navigator = Navigator()
    }
}