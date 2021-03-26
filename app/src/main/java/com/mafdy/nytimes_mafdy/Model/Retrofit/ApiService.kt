package com.mafdy.nytimes_mafdy.Model.Retrofit

import com.mafdy.nytimes_mafdy.Model.Retrofit.ResponseMappings.Base
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/svc/mostpopular/v2/viewed/7.json?api-key=2G1tA5ZvlEZuJvekGUYEx7f3HVK8McGi")
    fun getMostPopularData(): Call<Base>
}

