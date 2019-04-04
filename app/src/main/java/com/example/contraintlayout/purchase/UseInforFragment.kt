package com.example.contraintlayout.purchase


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.contraintlayout.ClickViewPager

import com.example.contraintlayout.R
import kotlinx.android.synthetic.main.fragment_use_infor.*
import mor.com.spaceshare.ui.base.BaseFragment

class UseInforFragment : BaseFragment() {

    private var clickViewPager: ClickViewPager? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_use_infor, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btnUserInfor.setOnClickListener {
            clickViewPager?.onClick()

        }
    }

    fun initListener(listener: ClickViewPager) {
        this.clickViewPager = listener
    }
}
