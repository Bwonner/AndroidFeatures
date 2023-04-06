package com.example.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.common.di.InjectUtils
import com.example.dashboard.databinding.FragmentDashboardBinding
import com.example.dashboard.di.DaggerDashboardComponent
import com.example.navigation.DeepLinkDestination
import com.example.navigation.NavigationFlow
import com.example.navigation.ToFlowNavigatable
import com.example.navigation.deepLinkNavigateTo
import com.example.utils.viewBinding
import javax.inject.Inject

class DashboardFragment : Fragment() {

    private val dashboardFragmentArgs: DashboardFragmentArgs by navArgs()

    private val binding by viewBinding { FragmentDashboardBinding.inflate(layoutInflater) }

    @Inject
    lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerDashboardComponent
            .builder()
            .baseComponent(InjectUtils.provideBaseComponent(requireContext().applicationContext))
            .build()
            .inject(this)

        binding.sampleText.text = dashboardViewModel.string

        binding.toNextFragment.setOnClickListener {
            findNavController().deepLinkNavigateTo(DeepLinkDestination.Next)
        }

        binding.toHomeFlow.setOnClickListener {
            (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.HomeFlow)
        }

        dashboardFragmentArgs.msg.let {
            if (it.isNotEmpty()) {
                Toast.makeText(requireContext(), dashboardFragmentArgs.msg, Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}