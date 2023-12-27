package com.geeks.hw36

import java.io.Serializable

data class Continent(
    val continentName: String,
    val continentImageURL: String,
    val continentCountries: ArrayList<String>): Serializable
