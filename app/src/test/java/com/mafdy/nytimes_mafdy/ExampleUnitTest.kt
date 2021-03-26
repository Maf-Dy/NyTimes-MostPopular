package com.mafdy.nytimes_mafdy

import com.mafdy.nytimes_mafdy.Model.Retrofit.ResponseMappings.Base
import com.mafdy.nytimes_mafdy.Model.Retrofit.RetrofitConnection
import org.junit.Test

import org.junit.Assert.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun nyApi_IsWorking()
    {
       var response = RetrofitConnection.initRetrofit()?.getMostPopularData()?.execute()

       assertEquals(response?.isSuccessful,true)

    }

    @Test
    fun nyApiParsingIsWorking()
    {
        var response = RetrofitConnection.initRetrofit()?.getMostPopularData()?.execute()

        assertEquals(response?.isSuccessful,true)

        assertEquals(response?.body()?.results?.size!! > 0 , true)

    }
}