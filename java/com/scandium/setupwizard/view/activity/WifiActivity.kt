package com.scandium.setupwizard.view.activity

import android.content.Intent
import com.scandium.setupwizard.action.WifiActions

class WifiActivity : ProxyActivity() {
    companion object {
        private const val TAG = "WifiActivity"
    }

    override fun launchActual() {
        WifiActions.launchSetup(this)
    }

    override fun handleResult(resultCode: Int, data: Intent?) {
        setMovingForward()
        WifiActions.handleResult(this, resultCode)
    }
}
