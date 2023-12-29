package com.geeks.hw36

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.geeks.hw36.databinding.FragmentContinentCountriesBinding

class ContinentCountriesFragment : Fragment() {
    private lateinit var binding: FragmentContinentCountriesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContinentCountriesBinding.inflate(layoutInflater)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val continent = arguments?.getSerializable(Keys.COUNTRY.name, Continent::class.java)
        binding.tvContinentName.text = continent?.continentName
        Glide.with(binding.root).load(continent?.continentImageURL).into(binding.ivContinentImage)
        if (continent != null) {
            binding.rvCountries.adapter = CountryAdapter(continent.continentCountries)
        }
    }
}