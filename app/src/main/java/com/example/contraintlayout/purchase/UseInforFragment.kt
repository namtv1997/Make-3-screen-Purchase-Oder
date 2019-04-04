package com.example.contraintlayout.purchase


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.contraintlayout.R
import com.example.contraintlayout.utils.switchFragment
import kotlinx.android.synthetic.main.fragment_use_infor.*
import mor.com.spaceshare.ui.base.BaseFragment

class UseInforFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_use_infor, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btnUserInfor.setOnClickListener {
            switchFragment(PaymentFragment())
        }
    }

}
