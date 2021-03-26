package com.mafdy.nytimes_mafdy.Model.Retrofit.ResponseMappings

import com.google.gson.annotations.SerializedName


data class Media_metadata (

@SerializedName("url") val url : String,
@SerializedName("format") val format : String,
@SerializedName("height") val height : Int,
@SerializedName("width") val width : Int

)