package com.example.dashboard.di

import com.example.common.di.AppProvider
import com.example.dashboard.DashboardFragment
import dagger.Component

@Component(
    dependencies = [AppProvider::class],
    modules = [DashboardModule::class]
)
interface DashboardComponent {
    fun inject(fragment: DashboardFragment)
}