package com.example.contraintlayout.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class OrderViewPagerAdapter(manager: FragmentManager):FragmentPagerAdapter(manager) {
    private val listFragments= mutableListOf<Fragment>()
    override fun getItem(position: Int): Fragment {
        return listFragments[position]

    }

    override fun getCount(): Int {
       return listFragments.size
    }
    fun addFragment(listFragments:List<Fragment>){
        this.listFragments.clear()
        this.listFragments.addAll(listFragments)
    }
}