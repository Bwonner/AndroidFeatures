package com.example.common.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.example.common.ViewModelProviderFactory
import com.example.utils.ResourceProvider
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface BaseModule {

    @Binds
    fun bindViewModelProviderFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory

    companion object {
        @Provides
        fun provideResourceProvider(context: Context): ResourceProvider = ResourceProvider(context)
    }
}