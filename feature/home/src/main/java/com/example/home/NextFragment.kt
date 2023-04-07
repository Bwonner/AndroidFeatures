package com.example.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.home.databinding.FragmentNextBinding
import com.example.navigation.DeepLinkDestination
import com.example.navigation.deepLinkNavigateTo
import com.example.utils.viewBinding

class NextFragment : Fragment() {

    private val binding by viewBinding { FragmentNextBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toDashboardFlowDeepLink.setOnClickListener {
            it.post {
                findNavController().deepLinkNavigateTo(DeepLinkDestination.Dashboard("From next fragment deeplink"))
            }
        }
    }
}