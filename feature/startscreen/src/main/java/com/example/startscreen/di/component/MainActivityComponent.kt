package com.example.startscreen.di.component

import com.example.startscreen.StartActivity
import com.example.startscreen.di.module.MainActivityModule
import dagger.Component

@Component(
    modules = [MainActivityModule::class]
)
interface MainActivityComponent {

    fun inject(activity: StartActivity)
}