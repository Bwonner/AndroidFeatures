package com.example.home

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.common.ui.BaseFragment
import com.example.home.databinding.FragmentHomeBinding
import com.example.home.di.DaggerHomeComponent
import com.example.navigation.NavigationFlow
import com.example.navigation.ToFlowNavigatable
import com.example.utils.viewBinding

class HomeFragment : BaseFragment(contentLayoutId = R.layout.fragment_home) {

    private val binding by viewBinding { FragmentHomeBinding.bind(requireView()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerHomeComponent
            .builder()
            .build()
            .inject(this)

        binding.toNextFragment.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.navigateToNextFragment())
        }

        binding.toDashboardFlow.setOnClickListener {
            (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.DashboardFlow("From home fragment"))
        }
    }
}