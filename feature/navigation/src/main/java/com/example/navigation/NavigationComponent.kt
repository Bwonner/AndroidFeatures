package com.example.navigation

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [NavigationDependencies::class], modules = [NavigationModule::class])
interface NavigationComponent {



    @Component.Factory
    interface Factory {
        fun create(@BindsInstance dependencies: NavigationDependencies): NavigationComponent
    }

    companion object {
        operator fun invoke(dependencies: NavigationDependencies) =
            DaggerNavigationComponent.factory().create(dependencies)
    }
}

val Context.navigationDepsProvider: NavigationDepsProvider
    get() = when (this) {
        is NavigationDepsProvider -> this
        is Application -> error("Application must implement NavigationDepsProvider")
        else -> applicationContext.navigationDepsProvider
    }