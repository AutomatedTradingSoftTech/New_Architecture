package com.example.newarchitecture.views.activity

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.newarchitecture.MyApplication
import com.example.newarchitecture.R
import com.example.newarchitecture.viewModels.DemoViewModel
import com.example.newarchitecture.views.base.BaseActivity

class MainActivity : BaseActivity() {

    lateinit var demoViewModel: DemoViewModel

    override fun getResourceLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onReady() {
        Log.e("onReady", "onReady")
        (application as MyApplication).netComponent?.inject(this)

        demoViewModel = ViewModelProvider(this).get(DemoViewModel::class.java)
        demoViewModel.getDemoData()?.observe(this, {

        })
    }

}