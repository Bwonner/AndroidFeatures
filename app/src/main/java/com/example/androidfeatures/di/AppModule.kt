package com.example.androidfeatures.di

import android.content.Context
import com.example.utils.ResourceProvider
import dagger.Module
import dagger.Provides

@Module
interface AppModule {

    companion object {
        @Provides
        fun provideResourceProvider(context: Context): ResourceProvider = ResourceProvider(context)
    }
}