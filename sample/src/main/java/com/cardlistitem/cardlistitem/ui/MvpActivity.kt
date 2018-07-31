package com.cardlistitem.cardlistitem.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.cardlistitem.cardlistitem.base.BasePresenter

abstract class MvpActivity<P : BasePresenter<*>> : AppCompatActivity() {

    protected lateinit var mvpPresenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        mvpPresenter = createPresenter()
        super.onCreate(savedInstanceState)
    }

    protected abstract fun createPresenter(): P

    override fun onDestroy() {
        super.onDestroy()
        mvpPresenter.onDetach()
    }
}