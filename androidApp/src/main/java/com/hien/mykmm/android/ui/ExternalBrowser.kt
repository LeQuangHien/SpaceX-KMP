package com.hien.mykmm.android.ui

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.browser.customtabs.CustomTabsIntent.SHARE_STATE_OFF

object ExternalBrowser {

    fun open(context: Context, uri: Uri) {
        val customTabsIntent = CustomTabsIntent.Builder()
            .setShowTitle(true)
            .setUrlBarHidingEnabled(true)
            .setShareState(SHARE_STATE_OFF)
            .build()

        customTabsIntent.launchUrl(context, uri)
    }
}