package com.example.androidfeatures.startscreen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.androidfeatures.R
import com.example.androidfeatures.databinding.FragmentStartBinding
import com.example.androidfeatures.startscreen.di.DaggerStartScreenComponent
import com.example.androidfeatures.startscreen.featureslist.FeaturesListAdapter
import com.example.common.ViewModelProviderFactory
import com.example.common.di.InjectUtils
import com.example.common.ui.BaseFragment
import com.example.utils.viewBinding
import javax.inject.Inject

class StartFragment : BaseFragment(contentLayoutId = R.layout.fragment_start) {

    private val binding by viewBinding { FragmentStartBinding.bind(requireView()) }

    private val adapter: FeaturesListAdapter = FeaturesListAdapter()

    @Inject
    lateinit var viewModelFactory: ViewModelProviderFactory

    private val viewModel: StartScreenViewModel by viewModels { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerStartScreenComponent
            .builder()
            .baseComponent(InjectUtils.provideBaseComponent(requireContext().applicationContext))
            .build()
            .inject(this)

        binding.featuresList.adapter = adapter
        adapter.setList(viewModel.getFeaturesList())
    }
}