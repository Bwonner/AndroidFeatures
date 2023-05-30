package com.example.dashboard.di

import androidx.lifecycle.ViewModel
import com.example.common.di.ViewModelKey
import com.example.dashboard.DashboardViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface DashboardModule {

    @Binds
    @IntoMap
    @ViewModelKey(DashboardViewModel::class)
    fun bindStartScreenViewModel(viewModel: DashboardViewModel): ViewModel
}