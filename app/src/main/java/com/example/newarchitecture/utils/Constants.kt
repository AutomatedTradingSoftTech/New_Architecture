package com.example.newarchitecture.utils

import android.content.Context
import android.widget.Toast

// all constants will be places here

fun Context.showToast(message : String, toastType : Int){
    Toast.makeText(this,message,toastType).show()
}