package com.example.startscreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfeatures.databinding.FeaturesListItemBinding

class FeaturesListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: MutableList<FeatureItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        FeatureItemViewHolder(
            FeaturesListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as FeatureItemViewHolder).onBind(items[position])
        holder.itemView.setOnClickListener {
            items[position].onClick.invoke()
        }
    }

    override fun getItemCount(): Int = items.size

    fun setList(list: List<FeatureItem>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }
}
