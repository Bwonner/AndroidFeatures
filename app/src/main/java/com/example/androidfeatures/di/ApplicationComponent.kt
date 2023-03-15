package com.example.androidfeatures.di

import android.content.Context
import com.example.dashboard.di.DashboardDeps
import com.example.utils.ResourceProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ApplicationModule::class]
)
interface ApplicationComponent : DashboardDeps {

    override val resourceProvider: ResourceProvider
//
//    fun inject(application: Application)
//    fun inject(activity: MainActivity)
//
//    fun dashboardComponent(): DashboardComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

    companion object {
        operator fun invoke(context: Context): ApplicationComponent =
            DaggerApplicationComponent.factory().create(context)
    }
}