package com.example.androidfeatures.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.common.di.ViewModelKey
import com.example.common.viewmodel.ViewModelFactory
import com.example.dashboard.DashboardViewModel
import com.example.startscreen.ui.StartScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * ViewModelsModule - add new viewModels here
 */

@Module
interface ViewModelsModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(StartScreenViewModel::class)
    fun bindStartScreenViewModel(viewModel: StartScreenViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DashboardViewModel::class)
    fun bindDashBoardViewModel(viewModel: DashboardViewModel): ViewModel
}