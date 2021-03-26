package com.mafdy.nytimes_mafdy.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mafdy.nytimes_mafdy.Model.Repository.MainRepository
import com.mafdy.nytimes_mafdy.Model.Retrofit.ResponseMappings.Base

class MainViewModel : ViewModel() {

    var servicesMostPopularLiveData: MutableLiveData<Base>? = null

    fun getMostPopular() : LiveData<Base>? {
        servicesMostPopularLiveData = MainRepository.getServicesApiCall()
        return servicesMostPopularLiveData
    }

}