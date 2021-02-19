package com.example.newarchitecture.utils.validation

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.net.ConnectivityManager
import android.util.Base64
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.Toast
import java.io.ByteArrayOutputStream

object CommonValidation {

    fun isNetworkAvailable(activity: Activity): Boolean {
        val connectivityManager = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo

        return if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
            true
        } else {
            Toast.makeText(activity,"No Internet Connection.",Toast.LENGTH_SHORT).show()
            false
        }
    }

    fun getBase64FromBitmap(bitmap: Bitmap): String {
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream)
        val byteFormat = stream.toByteArray()
        // get the base 64 string
        return Base64.encodeToString(byteFormat, Base64.NO_WRAP)
    }

    fun setZoomInOutAnimation(view: View) {
        val anim = ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        anim.duration = 500
        view.startAnimation(anim)

        /*val anim = AlphaAnimation(0.0f, 1.0f)
        anim.duration = 1000
        view.startAnimation(anim)*/
    }

    fun setAlphaAnimation(view: View) {
        val anim =
                ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        anim.duration = 1000
        view.startAnimation(anim)
    }

}