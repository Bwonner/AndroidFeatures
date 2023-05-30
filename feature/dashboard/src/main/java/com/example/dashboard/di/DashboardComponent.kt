package com.example.dashboard.di

import com.example.common.di.BaseComponent
import com.example.dashboard.DashboardFragment
import dagger.Component

@Component(dependencies = [BaseComponent::class], modules = [DashboardModule::class])
interface DashboardComponent {
    fun inject(fragment: DashboardFragment)
}