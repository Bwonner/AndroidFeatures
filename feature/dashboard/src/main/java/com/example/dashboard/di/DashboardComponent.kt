package com.example.dashboard.di

import android.app.Application
import android.content.Context
import com.example.dashboard.DashboardFragment
import com.example.utils.ResourceProvider
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [DashboardDeps::class], modules = [DashboardModule::class])
interface DashboardComponent {

    fun inject(dashboardFragment: DashboardFragment)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance dashboardDeps: DashboardDeps): DashboardComponent
    }

    companion object {
        operator fun invoke(dashboardDeps: DashboardDeps): DashboardComponent =
            DaggerDashboardComponent.factory().create(dashboardDeps)
    }
}

interface DashboardDeps {
    val resourceProvider: ResourceProvider
}

interface DashboardDepsProvider {
    val dashboardDeps: DashboardDeps
}

val Context.dashboardDepsProvider: DashboardDepsProvider
    get() = when (this) {
        is DashboardDepsProvider -> this
        is Application -> error("Application must implement DashboardDepsProvider")
        else -> applicationContext.dashboardDepsProvider
    }