package com.example.dashboard

import com.example.utils.ResourceProvider
import javax.inject.Inject

class DashboardViewModel @Inject constructor(
    private val resourceProvider: ResourceProvider
) {

    val string = resourceProvider.getString(com.example.utils.R.string.test_string)
}