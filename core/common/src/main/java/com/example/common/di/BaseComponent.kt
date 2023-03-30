package com.example.common.di

import android.app.Application
import android.content.Context
import com.example.utils.ResourceProvider
import dagger.BindsInstance
import dagger.Component

@Component(modules = [BaseModule::class])
interface BaseComponent {

    fun getResourceProvider(): ResourceProvider

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
    fun provideBaseComponent(applicationContext: Context): BaseComponent =
        if (applicationContext is BaseComponentProvider) {
            (applicationContext as BaseComponentProvider).provideBaseComponent()
        } else {
            throw IllegalStateException("Provide the application context which implement BaseComponentProvider")
        }
}