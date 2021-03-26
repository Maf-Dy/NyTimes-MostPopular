package com.mafdy.nytimes_mafdy.Model.Repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mafdy.nytimes_mafdy.Model.Retrofit.ResponseMappings.Base
import com.mafdy.nytimes_mafdy.Model.Retrofit.RetrofitConnection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainRepository {

    val serviceSetterGetter = MutableLiveData<Base>()

    fun getServicesApiCall(): MutableLiveData<Base> {

        val call = RetrofitConnection.initRetrofit()?.getMostPopularData()

        call?.enqueue(object: Callback<Base> {
            override fun onFailure(call: Call<Base>, t: Throwable) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<Base>,
                response: Response<Base>
            ) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", response.body().toString())

                val data = response.body()

                serviceSetterGetter.value = data
            }
        })

        return serviceSetterGetter
    }
}