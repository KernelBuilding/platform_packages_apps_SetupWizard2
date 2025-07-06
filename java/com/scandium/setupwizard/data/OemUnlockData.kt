package com.scandium.setupwizard.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.scandium.setupwizard.OEM_UNLOCKED_ACK_TIMER
import com.scandium.setupwizard.action.OemUnlockActions

object OemUnlockData : ViewModel() {
    val ackTimer = MutableLiveData(OEM_UNLOCKED_ACK_TIMER)

    init {
        OemUnlockActions
    }
}
