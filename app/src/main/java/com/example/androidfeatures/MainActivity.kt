package com.example.androidfeatures

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.androidfeatures.databinding.ActivityMainBinding
import com.example.androidfeatures.di.DaggerMainActivityComponent
import com.example.common.di.InjectUtils
import com.example.navigation.NavigationFlow
import com.example.navigation.Navigator
import com.example.navigation.ToFlowNavigatable
import javax.inject.Inject

class MainActivity : AppCompatActivity(), ToFlowNavigatable {

    @Inject
    lateinit var navigator: Navigator

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        DaggerMainActivityComponent
            .builder()
            .baseComponent(InjectUtils.provideBaseComponent(applicationContext))
            .build()
            .inject(this)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        navigator.navController = navController
    }

    override fun navigateToFlow(flow: NavigationFlow) {
        navigator.navigateToFlow(flow)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}