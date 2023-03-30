package com.example.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.home.di.DaggerHomeComponent
import com.example.navigation.NavigationFlow
import com.example.navigation.ToFlowNavigatable

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerHomeComponent
            .builder()
            .build()
            .inject(this)

        val toNextFragment = view.findViewById<Button>(R.id.toNextFragment)
        val toDashboardFlow = view.findViewById<Button>(R.id.toDashboardFlow)

        toNextFragment.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.navigateToNextFragment())
        }

        toDashboardFlow.setOnClickListener {
            (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.DashboardFlow("From home fragment"))
        }
    }
}