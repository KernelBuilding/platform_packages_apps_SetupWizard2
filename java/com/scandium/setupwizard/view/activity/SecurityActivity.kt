package com.scandium.setupwizard.view.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.scandium.setupwizard.action.SecurityActions
import com.scandium.setupwizard.action.SetupWizard
import com.scandium.setupwizard.data.SecurityData

class SecurityActivity : ProxyActivity() {

    companion object {
        private const val TAG = "SecurityActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isDeviceSecure() == true) {
            Log.d(TAG, "onCreate: skipping, device already secure")
            finish()
            SetupWizard.next(this)
        }
    }

    override fun launchActual() {
        SecurityActions.launchSetup(this)
    }

    private fun isDeviceSecure(): Boolean? {
        return SecurityData.isDeviceSecure.value
    }

    override fun handleResult(resultCode: Int, data: Intent?) {
        Log.d(TAG, "handleResult: $resultCode")
        SecurityActions.refreshSecurityStatus()
        if (isDeviceSecure() == true) finish()
        else setMovingForward()
        SecurityActions.handleResult(this, resultCode)
    }
}
