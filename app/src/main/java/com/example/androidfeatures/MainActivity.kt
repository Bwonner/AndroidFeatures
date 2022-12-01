package com.example.androidfeatures

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.androidfeatures.di.DaggerAndroidFeaturesApplicationComponent
import com.example.navigation.NavigationComponent
import com.example.navigation.NavigationFlow
import com.example.navigation.Navigator
import com.example.navigation.ToFlowNavigatable
import com.example.navigation.navigationDepsProvider
import javax.inject.Inject

class MainActivity : AppCompatActivity(), ToFlowNavigatable {

    @Inject
    lateinit var navigator: Navigator

    private val navigationComponent: NavigationComponent by lazy {
        NavigationComponent(applicationContext.navigationDepsProvider.deps)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        navigator.navController = navController
    }

    override fun navigateToFlow(flow: NavigationFlow) {
        navigator.navigateToFlow(flow)
    }
}