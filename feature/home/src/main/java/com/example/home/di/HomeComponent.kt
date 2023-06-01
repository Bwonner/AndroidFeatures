package com.example.home.di

import com.example.home.HomeFragment
import dagger.Component

@Component(modules = [HomeModule::class])
interface HomeComponent {

    fun inject(fragment: HomeFragment)
}