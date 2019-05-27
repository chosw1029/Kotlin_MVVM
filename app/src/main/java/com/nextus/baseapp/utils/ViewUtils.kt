package com.nextus.baseapp.utils

import android.content.res.Resources

/**
 * @author ReStartAllKill
 * @created on 2019-05-27
 * @modified by
 * @updated on
 */
object ViewUtils {

    fun dpToPx(dp: Float) : Int {
        val density = Resources.getSystem().displayMetrics.density
        return Math.round(dp * density)
    }

    fun pxToDp(px: Float) : Float {
        val densityDpi = Resources.getSystem().displayMetrics.densityDpi
        return px / (densityDpi / 160f)
    }

}