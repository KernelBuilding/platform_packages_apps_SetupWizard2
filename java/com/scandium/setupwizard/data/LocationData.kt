package com.scandium.setupwizard.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.scandium.setupwizard.action.LocationActions

object LocationData : ViewModel() {
    val enabled = MutableLiveData<Boolean>()

    init {
        LocationActions
    }
}
