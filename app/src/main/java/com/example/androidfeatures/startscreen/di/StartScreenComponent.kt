package com.example.androidfeatures.startscreen.di

import com.example.androidfeatures.startscreen.StartFragment
import com.example.common.di.BaseComponent
import dagger.Component

@Component(
    dependencies = [BaseComponent::class],
    modules = [StartScreenModule::class]
)
interface StartScreenComponent {

    fun inject(fragment: StartFragment)
}