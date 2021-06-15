package com.example.oishii.utils

import android.widget.Toast
import com.example.oishii.OishiiApplication


object Toasts {

   private fun generalToast(text: String) {
        Toast.makeText(
            OishiiApplication.application.applicationContext,
            text,
            Toast.LENGTH_LONG
        ).show()
    }

    fun apiErrorCodes(errorCode: Int){
        generalToast(errorToString(errorCode))
    }

    private fun errorToString(errorCode: Int): String {
    return when(errorCode){
        404 -> {
            "404 Not Found"
        }
        401 -> {
            "401 Unauthorized"
        }
        500 -> {
            "500 Internal Server Error"
        }
        else -> "Something went wrong"
    }
    }

    fun cameraError() {
        generalToast("Could not detect camera")
    }
}
