package com.example.androidfeatures.startscreen.featureslist

import androidx.recyclerview.widget.RecyclerView
import com.example.androidfeatures.databinding.FeaturesListItemBinding

class FeatureItemViewHolder(private val binding: FeaturesListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: FeatureItem) {
        binding.featureTitle.text = item.featureTitle
        binding.root.setOnClickListener {
            item.onClick.invoke()
        }
    }
}