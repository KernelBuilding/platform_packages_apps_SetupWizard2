package com.scandium.setupwizard.view.activity

import android.view.View
import android.widget.CheckBox
import com.scandium.setupwizard.R
import com.scandium.setupwizard.action.LocationActions
import com.scandium.setupwizard.action.SetupWizard
import com.scandium.setupwizard.data.LocationData

class LocationActivity : SetupWizardActivity(
    R.layout.activity_location,
    R.drawable.baseline_location_on_glif,
    R.string.location_services
) {
    private lateinit var enabled: CheckBox

    override fun bindViews() {
        enabled = requireViewById(R.id.enabled)
        LocationData.enabled.observe(this) { enabled.isChecked = it }
    }

    override fun setupActions() {
        requireViewById<View>(R.id.enabled_container).setOnClickListener {
            LocationActions.setEnabled(!enabled.isChecked)
        }
        enabled.setOnClickListener { LocationActions.setEnabled(enabled.isChecked) }
        primaryButton.setOnClickListener { SetupWizard.next(this) }
    }
}
