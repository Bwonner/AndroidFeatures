package com.example.androidfeatures.startscreen.di

import androidx.lifecycle.ViewModel
import com.example.androidfeatures.startscreen.StartScreenViewModel
import com.example.common.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface StartScreenModule {

    @Binds
    @IntoMap
    @ViewModelKey(StartScreenViewModel::class)
    fun bindStartScreenViewModel(viewModel: StartScreenViewModel): ViewModel
}