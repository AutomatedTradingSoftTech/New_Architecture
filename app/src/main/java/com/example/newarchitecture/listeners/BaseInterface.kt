package com.example.newarchitecture.listeners

interface BaseInterface {

    // hide show loader
    fun showLoader()
    fun hideLoader()

    // hide show keyboard
    fun hideKeyboard()
    fun showKeyboard()

    // show alert dialog
    fun showAlertDialog(title : String, msg : String, positiveText : String, negativeText : String)
}