package com.muzafferatmaca.tmdb_movie_app.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class HomeFragmentViewPagerAdapter(supportFragmentManager : FragmentManager) : FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val  fragmentList = ArrayList<Fragment>()
    private val fragmentTitleList = ArrayList<String>()


    override fun getCount(): Int = fragmentList.size

    override fun getItem(position: Int): Fragment   = fragmentList[position]

    override fun getPageTitle(position: Int): CharSequence?  = fragmentTitleList[position]

    fun addFragment (fragment: Fragment, title : String){

        fragmentList.add(fragment)
        fragmentTitleList.add(title)



    }
}