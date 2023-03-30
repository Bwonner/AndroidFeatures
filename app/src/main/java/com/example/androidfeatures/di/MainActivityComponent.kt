package com.example.androidfeatures.di

import com.example.androidfeatures.MainActivity
import com.example.common.di.BaseComponent
import dagger.Component

@Component(
    dependencies = [BaseComponent::class],
    modules = [MainActivityModule::class]
)
interface MainActivityComponent {
    fun inject(activity: MainActivity)
}