package com.example.androidfeatures.startscreen

import com.example.androidfeatures.startscreen.featureslist.FeatureItem
import com.example.common.BaseViewModel
import javax.inject.Inject

class StartScreenViewModel @Inject constructor() : BaseViewModel() {

    fun getFeaturesList(): List<FeatureItem> =
        listOf(
            FeatureItem("Permissions", {}),
            FeatureItem("Feature 1"),
            FeatureItem("Feature 2"),
            FeatureItem("Feature 3"),
            FeatureItem("Feature 4"),
            FeatureItem("Feature 5"),
            FeatureItem("Feature 6"),
            FeatureItem("Feature 7")
        )
}