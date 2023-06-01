package com.example.startscreen.di.component

import com.example.common.di.AppProvider
import com.example.startscreen.di.module.StartScreenModule
import com.example.startscreen.ui.StartFragment
import dagger.Component

@Component(
    dependencies = [AppProvider::class],
    modules = [StartScreenModule::class]
)
interface StartScreenComponent {

    fun inject(fragment: StartFragment)
}