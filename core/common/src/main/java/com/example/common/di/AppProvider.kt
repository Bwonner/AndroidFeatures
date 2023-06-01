package com.example.common.di

import com.example.common.viewmodel.ViewModelFactory
import com.example.utils.ResourceProvider

interface AppProvider {

    fun getResourceProvider(): ResourceProvider

    fun getViewModelProviderFactory(): ViewModelFactory
}