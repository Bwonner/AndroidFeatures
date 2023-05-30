package com.example.home

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.common.ui.BaseFragment
import com.example.home.databinding.FragmentNextBinding
import com.example.navigation.DeepLinkDestination
import com.example.navigation.deepLinkNavigateTo
import com.example.utils.viewBinding

class NextFragment : BaseFragment(contentLayoutId = R.layout.fragment_next) {

    private val binding by viewBinding { FragmentNextBinding.bind(requireView()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toDashboardFlowDeepLink.setOnClickListener {
            it.post {
                findNavController().deepLinkNavigateTo(DeepLinkDestination.Dashboard("From next fragment deeplink"))
            }
        }
    }
}