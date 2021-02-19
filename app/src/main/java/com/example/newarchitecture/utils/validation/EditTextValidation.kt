package com.example.newarchitecture.utils.validation

import android.app.Activity
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

object EditTextValidation {
    fun isEmpty(string: String): Boolean {
        if (string != null && !string.equals("")) {
            return false
        }
        return true
    }

    fun isEmail(email: String, inputLayout: TextInputLayout): Boolean {
        if (email.contains(" ")) {
            inputLayout.error = "* Remove space from Email id."
            return false
        } else {
            val expression = ("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
            val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
            val matcher = pattern.matcher(email)

            if (matcher.matches()) {
                inputLayout.isErrorEnabled = false
                return true
            } else {
                inputLayout.error = "* Enter valid email id."
                return false
            }
        }
    }

    fun isIfscCode(code : String, inputLayout: TextInputLayout) : Boolean{
        if (code.contains(" ")) {
            inputLayout.error = "* Remove space from IFSC."
            return false
        } else {
            val regex = "^[A-Z]{4}0[A-Z0-9]{6}$"
            val pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE)
            val matcher = pattern.matcher(code)

            return if (matcher.matches()) {
                inputLayout.isErrorEnabled = false
                true
            } else {
                inputLayout.error = "* Enter valid IFSC code."
                false
            }
        }
    }

    fun checkFieldNotEmpty(editText: TextInputEditText, inputLayout: TextInputLayout): Boolean {
        return if (editText.text!!.toString().trim().equals("")) {
            inputLayout.error = "* field must not be empty."
            false
        } else {
            inputLayout.isErrorEnabled = false
            true
        }
    }

    fun setEditTextWatcher(editText: TextInputEditText, textInputLayout: TextInputLayout) {
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s?.length!! > 0) {
                    textInputLayout.isErrorEnabled = false
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })
    }

    fun hideKeyboard(activity: Activity) {
        activity.window.setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        )
    }

    fun hideFragmentKeyboard(activity: Activity) {
        val inputManager = activity
            .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        // check if no view has focus:
        val currentFocusedView = activity.currentFocus
        if (currentFocusedView != null) {
            inputManager!!.hideSoftInputFromWindow(currentFocusedView.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }
}