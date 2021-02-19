package com.example.newarchitecture.views.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.example.newarchitecture.listeners.BaseInterface

abstract class BaseActivity : AppCompatActivity(), BaseInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getResourceLayoutId())
        onReady()
    }

    @LayoutRes
    protected abstract fun getResourceLayoutId() : Int

    protected abstract fun onReady()

    override fun showLoader() {
        TODO("Not yet implemented")
    }

    override fun hideLoader() {
        TODO("Not yet implemented")
    }

    override fun hideKeyboard() {
        TODO("Not yet implemented")
    }

    override fun showKeyboard() {
        TODO("Not yet implemented")
    }

    override fun showAlertDialog(
        title: String,
        msg: String,
        positiveText: String,
        negativeText: String
    ) {
        TODO("Not yet implemented")
    }
}