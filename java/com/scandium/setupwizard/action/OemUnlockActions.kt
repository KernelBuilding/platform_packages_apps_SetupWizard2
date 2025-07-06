package com.scandium.setupwizard.action

import com.scandium.setupwizard.OEM_UNLOCKED_ACK_TIMER
import com.scandium.setupwizard.appContext
import com.scandium.setupwizard.data.OemUnlockData
import com.scandium.setupwizard.view.activity.OemUnlockActivity
import com.scandium.setupwizard.view.activity.WelcomeActivity

object OemUnlockActions {
    private const val TAG = "OemUnlockActions"

    fun rebootToBootloader() {
        WelcomeActions.rebootToBootloader()
    }

    fun next(activity: OemUnlockActivity) {
        SetupWizard.next(activity, WelcomeActivity::class.java)
        return
    }

    fun startAckTimer(time: Int = OEM_UNLOCKED_ACK_TIMER) {
        if (time <= 0) return
        appContext.mainThreadHandler.postDelayed({
            OemUnlockData.ackTimer.value = time - 1
            startAckTimer(time - 1)
        }, 1_000)
    }
}
