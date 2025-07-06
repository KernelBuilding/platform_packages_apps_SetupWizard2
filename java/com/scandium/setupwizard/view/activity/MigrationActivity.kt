package com.scandium.setupwizard.view.activity

import android.content.Intent
import android.util.Log
import android.view.View
import com.scandium.setupwizard.R
import com.scandium.setupwizard.action.MigrationActions
import com.scandium.setupwizard.action.SetupWizard

class MigrationActivity : SetupWizardActivity(
    R.layout.activity_migration,
    R.drawable.baseline_restore_glif,
    R.string.restore_apps_and_data,
    R.string.data_restore_desc
) {
    companion object {
        private const val TAG = "MigrationActivity"
    }

    override fun bindViews() {
        primaryButton.setText(this, R.string.restore)
    }

    override fun setupActions() {
        secondaryButton.setOnClickListener { SetupWizard.next(this) }
        primaryButton.setOnClickListener { MigrationActions.launchMigration(this) }
    }

    override fun onActivityResult(resultCode: Int, data: Intent?) {
        Log.d(TAG, "onActivityResult: $resultCode, data=$data")
        MigrationActions.handleResult(this, resultCode)
        super.onActivityResult(resultCode, data)
    }
}
