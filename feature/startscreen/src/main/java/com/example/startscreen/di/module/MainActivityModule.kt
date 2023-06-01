package com.example.startscreen.di.module

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