package com.example.androidfeatures

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidfeatures.databinding.FragmentStartBinding
import com.example.navigation.NavigationFlow
import com.example.navigation.ToFlowNavigatable

class StartFragment : Fragment() {

    private var binding: FragmentStartBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding?.root
    }

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

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}