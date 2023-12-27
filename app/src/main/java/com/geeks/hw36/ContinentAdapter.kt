package com.geeks.hw36

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.geeks.hw36.databinding.ItemContinentBinding

class ContinentAdapter(
    private val continents: ArrayList<Continent>,
    private val onClick: OnItemClick
) : Adapter<ContinentItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContinentItemViewHolder {
        return ContinentItemViewHolder(
            ItemContinentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return continents.size
    }

    override fun onBindViewHolder(holder: ContinentItemViewHolder, position: Int) {
        holder.onBind(continents[position])
        holder.itemView.setOnClickListener {
            onClick.onItemClick(position)
        }
    }
}

class ContinentItemViewHolder(itemView: View) : ViewHolder(itemView) {
    private lateinit var binding: ItemContinentBinding

    constructor(binding: ItemContinentBinding) : this(binding.root) {
        this.binding = binding
    }

    fun onBind(continent: Continent) {
        binding.tvContinentName.text = continent.continentName
        Glide.with(binding.root).load(continent.continentImageURL)
            .into(binding.ivContinentImage)
    }
}

interface OnItemClick {
    fun onItemClick(position: Int)
}