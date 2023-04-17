package com.example.androidfeatures

import android.os.Bundle
import android.view.View
import com.example.androidfeatures.databinding.FragmentStartBinding
import com.example.navigation.NavigationFlow
import com.example.navigation.ToFlowNavigatable
import com.example.utils.viewBinding
import ui.BaseFragment

class StartFragment : BaseFragment(contentLayoutId = R.layout.fragment_start) {

    private val binding by viewBinding { FragmentStartBinding.bind(requireView()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // decide where to go on the first app launch, check auth tokens if login needed etc...

        (0..1).random().let {
            when (it) {
                0 -> (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.HomeFlow)
                1 -> (requireActivity() as ToFlowNavigatable).navigateToFlow(
                    NavigationFlow.DashboardFlow(
                        "From start fragment"
                    )
                )
            }
        }
    }
}