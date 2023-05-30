package com.example.common.di

import android.app.Application
import android.content.Context
import com.example.common.ViewModelProviderFactory
import com.example.utils.ResourceProvider
import dagger.BindsInstance
import dagger.Component

@Component(modules = [BaseModule::class])
interface BaseComponent {

    fun getResourceProvider(): ResourceProvider
    fun getViewModelProviderFactory(): ViewModelProviderFactory

    fun inject(app: Application)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): BaseComponent
    }
}

interface BaseComponentProvider {

    fun provideBaseComponent(): BaseComponent
}

object InjectUtils {
    fun provideBaseComponent(applicationContext: Context): BaseComponent {
        check(applicationContext is BaseComponentProvider) {
            "Provide the application context which implement BaseComponentProvider"
        }
        return applicationContext.provideBaseComponent()
    }
}