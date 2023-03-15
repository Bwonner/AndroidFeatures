package com.example.androidfeatures.di

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import com.example.dashboard.di.DashboardDeps
import com.example.dashboard.di.DashboardDepsProvider

class AndroidFeaturesApplication : Application(), DashboardDepsProvider {

    private val applicationComponent: ApplicationComponent by lazy {
         ApplicationComponent(this)
       // DaggerApplicationComponent.factory.create(this)
    }

//    companion object {
//        @JvmStatic
//        fun applicationComponent(context: Context) =
//            (context.applicationContext as AndroidFeaturesApplication).applicationComponent
//    }

        override fun onCreate() {
        super.onCreate()

//        applicationComponent = DaggerAndroidFeaturesApplicationComponent.factory.create(
//            AndroidFeaturesApplicationModule(applicationContext),
//            provideDashboard()
//        )
       // applicationComponent.inject(this)
    }

    override val dashboardDeps: DashboardDeps = applicationComponent
//    override fun provideDashboard(): DashboardComponent = //dashboardComponent
//        applicationComponent.dashboardComponent().create()
}

//fun Activity.applicationComponent() = AndroidFeaturesApplication.applicationComponent(this)
//fun Fragment.applicationComponent() =
//    AndroidFeaturesApplication.applicationComponent(requireContext())