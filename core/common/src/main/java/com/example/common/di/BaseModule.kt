package com.example.common.di

import android.content.Context
import com.example.utils.ResourceProvider
import dagger.Module
import dagger.Provides

@Module
class BaseModule {

    @Provides
    fun provideResourceProvider(context: Context): ResourceProvider = ResourceProvider(context)
}