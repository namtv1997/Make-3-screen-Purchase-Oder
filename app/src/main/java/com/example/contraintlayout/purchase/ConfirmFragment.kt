package com.example.contraintlayout.purchase


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.contraintlayout.ClickViewPager
import com.example.contraintlayout.R
import com.example.contraintlayout.dialog.DialogPurchaseFragment
import kotlinx.android.synthetic.main.fragment_confirm.*
import mor.com.spaceshare.ui.base.BaseFragment


class ConfirmFragment : BaseFragment() {
    private var mDialogPurchaseFragment: DialogPurchaseFragment? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_confirm, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btnConfirm.setOnClickListener {
            mDialogPurchaseFragment=DialogPurchaseFragment()
            mDialogPurchaseFragment?.show(activity?.supportFragmentManager, "")

        }
    }

}
