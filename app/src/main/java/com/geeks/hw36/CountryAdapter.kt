package com.geeks.hw36

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.geeks.hw36.databinding.ItemCountryBinding

class CountryAdapter(private val countryList: ArrayList<String>) :
    Adapter<CountryItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryItemViewHolder {
        return CountryItemViewHolder(
            ItemCountryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountryItemViewHolder, position: Int) {
        holder.onBind(countryList[position])
        holder.itemView.setOnClickListener {
            Toast.makeText(it.context, countryList[position], Toast.LENGTH_SHORT).show()
        }
    }
}

class CountryItemViewHolder(itemView: View) : ViewHolder(itemView) {
    private lateinit var binding: ItemCountryBinding
    constructor(binding: ItemCountryBinding) : this(binding.root) {
        this.binding = binding
    }

    fun onBind(countryName: String) {
        binding.tvCountryName.text = countryName
    }
}