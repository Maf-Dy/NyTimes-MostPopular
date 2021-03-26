package com.mafdy.nytimes_mafdy.Model.Retrofit.ResponseMappings

import com.google.gson.annotations.SerializedName


data class Base (

	@SerializedName("status") val status : String,
	@SerializedName("copyright") val copyright : String,
	@SerializedName("num_results") val num_results : Int,
	@SerializedName("results") val results : List<Results>
)