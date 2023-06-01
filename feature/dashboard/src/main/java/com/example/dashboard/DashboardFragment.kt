package com.example.dashboard

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.common.extension.appComponent
import com.example.common.ui.BaseFragment
import com.example.common.viewmodel.ViewModelFactory
import com.example.dashboard.databinding.FragmentDashboardBinding
import com.example.dashboard.di.DaggerDashboardComponent
import com.example.navigation.DeepLinkDestination
import com.example.navigation.NavigationFlow
import com.example.navigation.deepLinkNavigateTo
import com.example.navigation.navigateToFlow
import com.example.utils.viewBinding
import javax.inject.Inject

class DashboardFragment : BaseFragment(contentLayoutId = R.layout.fragment_dashboard) {

    private val dashboardFragmentArgs: DashboardFragmentArgs by navArgs()

    private val binding by viewBinding { FragmentDashboardBinding.bind(requireView()) }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: DashboardViewModel by viewModels { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerDashboardComponent
            .builder()
            .appProvider(appComponent())
            .build()
            .inject(this)

        binding.sampleText.text = viewModel.string

        binding.toNextFragment.setOnClickListener {
            findNavController().deepLinkNavigateTo(DeepLinkDestination.Next)
        }

        binding.toHomeFlow.setOnClickListener {
            navigateToFlow(NavigationFlow.HomeFlow)
        }

        dashboardFragmentArgs.msg.let {
            if (it.isNotEmpty()) {
                Toast.makeText(requireContext(), dashboardFragmentArgs.msg, Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}