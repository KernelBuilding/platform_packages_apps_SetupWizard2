package com.scandium.setupwizard.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.scandium.setupwizard.action.DateTimeActions

object DateTimeData : ViewModel() {
    val date = MutableLiveData<String>()
    val time = MutableLiveData<String>()
    val timeZone = MutableLiveData<String>()

    init {
        DateTimeActions
    }
}
