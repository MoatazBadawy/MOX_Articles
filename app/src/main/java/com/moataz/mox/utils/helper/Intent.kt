package com.moataz.mox.utils.helper

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import com.moataz.mox.R
import com.moataz.mox.data.model.Item

object Intent {
    fun shareArticle(context: Context, article: Item) {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        val shareSubText =
            """
                   Check out this great article from *MOX APP*
                   
                   """.trimIndent()
        val shareBodyText = shareSubText + article.link
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubText)
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareBodyText)
        context.startActivity(Intent.createChooser(shareIntent, "Share With"))
    }

    fun openInBrowser(context: Context, article: Item) {
        // if there's no browser, d
        val customTabIntent = CustomTabsIntent.Builder()
        customTabIntent.setToolbarColor(Color.parseColor("#ffffff"))
        customTabIntent.setStartAnimations(
            context,
            R.anim.slide_in_right,
            R.anim.slide_out_left
        )
        customTabIntent.setExitAnimations(
            context,
            R.anim.slide_in_left,
            R.anim.slide_out_right
        )
        customTabIntent.setShowTitle(true)
        openCustomTabs(
            context,
            customTabIntent.build(),
            Uri.parse(article.link)
        )
    }
}

private fun openCustomTabs(
    activity: Context?,
    customTabsIntent: CustomTabsIntent,
    uri: Uri?
) {
    val packageName = "com.android.chrome"
    customTabsIntent.intent.setPackage(packageName)
    customTabsIntent.launchUrl(activity!!, uri!!)
}