package com.example.startscreen.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.androidfeatures.R
import com.example.androidfeatures.databinding.FragmentStartBinding
import com.example.common.extension.appComponent
import com.example.common.ui.BaseFragment
import com.example.common.viewmodel.ViewModelFactory
import com.example.startscreen.adapter.FeaturesListAdapter
import com.example.startscreen.di.component.DaggerStartScreenComponent
import com.example.utils.viewBinding
import javax.inject.Inject

class StartFragment : BaseFragment(contentLayoutId = R.layout.fragment_start) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: StartScreenViewModel by viewModels { viewModelFactory }
    private val binding by viewBinding { FragmentStartBinding.bind(requireView()) }
    private val adapter: FeaturesListAdapter = FeaturesListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerStartScreenComponent
            .builder()
            .appProvider(appComponent())
            .build()
            .inject(this)

        binding.featuresList.adapter = adapter
        adapter.setList(viewModel.getFeaturesList())
    }
}