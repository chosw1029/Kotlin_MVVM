package com.nextus.baseapp.utils

import android.util.Patterns
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author ReStartAllKill
 * @created on 2019-05-27
 * @modified by
 * @updated on
 */
object CommonUtils {

    fun getTimeStamp(format: String) : String {
        return SimpleDateFormat(format, Locale.KOREA).format(Date())
    }

    fun getTime() : Long {
        return System.currentTimeMillis()
    }

    fun isEmailValid(email: String) : Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}