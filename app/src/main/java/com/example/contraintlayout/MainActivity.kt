package com.example.contraintlayout


import android.os.Bundle
import com.example.contraintlayout.purchase.ConfirmFragment
import com.example.contraintlayout.purchase.PaymentFragment
import com.example.contraintlayout.purchase.UseInforFragment
import com.example.contraintlayout.utils.replaceFragmentInActivity
import com.example.contraintlayout.utils.setupActionBar
import kotlinx.android.synthetic.main.include_toolbar.*
import mor.com.spaceshare.ui.base.BaseActivity


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        setupActionBar(toolbar) {
//            setDisplayHomeAsUpEnabled(true)
//            setHomeAsUpIndicator(R.drawable.ic_back)
//            title = ""
//        }
        replaceFragmentInActivity(findOrCreateContent(), R.id.frameContent)

    }
    private fun findOrCreateContent() =
        supportFragmentManager.findFragmentById(R.id.frameContent) ?: UseInforFragment()

}
