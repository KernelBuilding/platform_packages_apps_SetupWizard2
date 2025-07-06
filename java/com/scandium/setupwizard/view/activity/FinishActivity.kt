package com.scandium.setupwizard.view.activity

import android.view.View
import android.widget.CheckBox
import com.scandium.setupwizard.R
import com.scandium.setupwizard.action.FinishActions
import com.scandium.setupwizard.action.SetupWizard.isPrimaryUser
import com.scandium.setupwizard.data.FinishData
import com.scandium.setupwizard.data.FinishData.disableOemUnlockingVisible

class FinishActivity : SetupWizardActivity(
    R.layout.activity_finish,
    R.drawable.baseline_done_all_glif,
    R.string.you_re_all_set_now,
    if (isPrimaryUser) R.string.device_setup_done_desc else R.string.profile_setup_done_desc
) {
    private lateinit var disableOemUnlockingContainer: View
    private lateinit var disableOemUnlocking: CheckBox

    override fun bindViews() {
        disableOemUnlockingContainer = requireViewById(R.id.disable_oem_unlocking_container)
        disableOemUnlocking = requireViewById(R.id.disable_oem_unlocking)
        primaryButton.setText(this, R.string.start)
        if (disableOemUnlockingVisible) {
            disableOemUnlocking.isChecked = FinishData.disableOemUnlockingChecked
            FinishData.oemUnlockingEnabled.observe(this) {
                disableOemUnlockingContainer.visibility = if (it) View.VISIBLE else View.GONE
            }
        } else {
            disableOemUnlockingContainer.visibility = View.GONE
            disableOemUnlocking.isChecked = false
        }
    }

    override fun setupActions() {
        disableOemUnlockingContainer.setOnClickListener {
            disableOemUnlocking.isChecked = !disableOemUnlocking.isChecked
        }
        primaryButton.setOnClickListener {
            val disableOemUnlocking = disableOemUnlockingVisible && disableOemUnlocking.isChecked
            FinishActions.finish(this, disableOemUnlocking)
        }
    }
}
