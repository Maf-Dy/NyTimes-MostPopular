package com.mafdy.nytimes_mafdy.Model.Retrofit


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitConnection {
    private var mApiServices: ApiService? = null
    fun initRetrofit(): ApiService? {
        if (mApiServices == null) {
            mApiServices = Retrofit.Builder().baseUrl("http://api.nytimes.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiService::class.java)
        }
        return mApiServices
    }


}
