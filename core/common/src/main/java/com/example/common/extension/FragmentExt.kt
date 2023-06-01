package com.example.common.extension

import androidx.fragment.app.Fragment
import com.example.common.di.AppComponentProvider
import com.example.common.di.AppProvider

fun Fragment.appComponent(): AppProvider =
    requireContext().applicationContext.run {
        check(this is AppComponentProvider) {
            "Provide the application context which implement AppComponentProvider"
        }
        provideAppComponent()
    }