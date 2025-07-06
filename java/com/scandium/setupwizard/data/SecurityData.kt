package com.scandium.setupwizard.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.scandium.setupwizard.action.SecurityActions

object SecurityData : ViewModel() {

    val isDeviceSecure = MutableLiveData<Boolean>()

    init {
        SecurityActions
    }
}
