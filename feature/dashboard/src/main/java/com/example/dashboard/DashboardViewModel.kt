package com.example.dashboard

import com.example.common.BaseViewModel
import com.example.utils.ResourceProvider
import javax.inject.Inject

class DashboardViewModel @Inject constructor(
    private val resourceProvider: ResourceProvider
) : BaseViewModel() {

    val string = resourceProvider.getString(com.example.utils.R.string.test_string)
}