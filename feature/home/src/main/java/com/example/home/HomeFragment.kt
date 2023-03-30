package com.example.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.home.databinding.FragmentHomeBinding
import com.example.home.di.DaggerHomeComponent
import com.example.navigation.NavigationFlow
import com.example.navigation.ToFlowNavigatable

class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerHomeComponent
            .builder()
            .build()
            .inject(this)

        binding?.toNextFragment?.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.navigateToNextFragment())
        }

        binding?.toDashboardFlow?.setOnClickListener {
            (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.DashboardFlow("From home fragment"))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}