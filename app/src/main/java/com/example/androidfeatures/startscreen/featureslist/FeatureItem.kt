package com.example.androidfeatures.startscreen.featureslist

data class FeatureItem(val featureTitle: String, val onClick: () -> Unit = {})