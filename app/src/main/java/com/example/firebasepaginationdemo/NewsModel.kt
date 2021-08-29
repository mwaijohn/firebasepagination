package com.example.firebasepaginationdemo


import com.google.gson.annotations.SerializedName

data class NewsModel(
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("headline")
    val headline: String? = null
)