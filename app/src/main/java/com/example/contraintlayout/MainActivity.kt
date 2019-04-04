package com.example.contraintlayout


import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.contraintlayout.adapter.OrderViewPagerAdapter
import com.example.contraintlayout.purchase.ConfirmFragment
import com.example.contraintlayout.purchase.PaymentFragment
import com.example.contraintlayout.purchase.UseInforFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ClickViewPager {
    private lateinit var adapterOrder: OrderViewPagerAdapter
    private var current = 0

    private var listFragments = listOf<Fragment>(
        UseInforFragment(),
        PaymentFragment(),
        ConfirmFragment()
    )
    private var mchangeOrderStep: OrderStep? = null
    var viewPagerPageChangeListener = object : ViewPager.OnPageChangeListener {

        override fun onPageScrollStateChanged(state: Int) {

        }

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        }

        override fun onPageSelected(position: Int) {
            current = position
            if (position ==  listFragments.size -1 ) {
                ibDollar.background =getDrawable(R.drawable.bg_icon_status_checked)
                viewLeft.background =getDrawable(R.drawable.bg_icon_status_checked)
                tvPayment.setTextColor(Color.parseColor("#2BBA56"))
                tvConfirm.setTextColor(Color.parseColor("#2BBA56"))
                ibTick.background =getDrawable(R.drawable.bg_icon_status_checked)
                viewRight.background =getDrawable(R.drawable.bg_icon_status_checked)
            } else {
               ibDollar.background=getDrawable(R.drawable.bg_icon_status_uncheck)
                viewLeft.background=getDrawable(R.drawable.bg_icon_status_uncheck)
                ibTick.background=getDrawable(R.drawable.bg_icon_status_uncheck)
                tvConfirm.setTextColor(Color.parseColor("#e4e4e6"))
                tvPayment.setTextColor(Color.parseColor("#e4e4e6"))
                viewRight.background=getDrawable(R.drawable.bg_icon_status_uncheck)

                if (position ==  listFragments.size -2 ) {
                    tvPayment.setTextColor(Color.parseColor("#2BBA56"))
                    ibDollar.background =getDrawable(R.drawable.bg_icon_status_checked)
                    viewLeft.background =getDrawable(R.drawable.bg_icon_status_checked)

                } else {
                    tvConfirm.setTextColor(Color.parseColor("#e4e4e6"))
                    ibDollar.background=getDrawable(R.drawable.bg_icon_status_uncheck)
                    viewLeft.background=getDrawable(R.drawable.bg_icon_status_uncheck)

                }
            }


        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        adapterOrder = OrderViewPagerAdapter(supportFragmentManager)
        adapterOrder.addFragment(listFragments)
        vpOrder.adapter = adapterOrder
        vpOrder.addOnPageChangeListener(viewPagerPageChangeListener)


        (listFragments[0] as UseInforFragment).initListener(this)
        (listFragments[1] as PaymentFragment).initListener1(this)

    }

    override fun onClick() {
        current += 1
        if (current >= listFragments.size) {
            current = 0
        } else{
            vpOrder.currentItem = current
        }

    }



}
