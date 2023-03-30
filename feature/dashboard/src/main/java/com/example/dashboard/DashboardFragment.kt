package com.example.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.common.di.InjectUtils
import com.example.dashboard.di.DaggerDashboardComponent
import com.example.navigation.DeepLinkDestination
import com.example.navigation.NavigationFlow
import com.example.navigation.ToFlowNavigatable
import com.example.navigation.deepLinkNavigateTo
import javax.inject.Inject

class DashboardFragment : Fragment() {

    private val dashboardFragmentArgs: DashboardFragmentArgs by navArgs()

    @Inject
    lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerDashboardComponent
            .builder()
            .baseComponent(InjectUtils.provideBaseComponent(requireContext().applicationContext))
            .build()
            .inject(this)

        val toNextFragment = view.findViewById<Button>(R.id.toNextFragment)
        val toHomeFlow = view.findViewById<Button>(R.id.toHomeFlow)
        val sampleText = view.findViewById<TextView>(R.id.sampleText)
        sampleText.text = dashboardViewModel.string

        toNextFragment.setOnClickListener {
            findNavController().deepLinkNavigateTo(DeepLinkDestination.Next)
        }

        toHomeFlow.setOnClickListener {
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