package com.moataz.mox.ui.app.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.moataz.mox.ui.android.AndroidFragment
import com.moataz.mox.ui.kotlin.KotlinFragment
import com.moataz.mox.ui.programming.ProFragment
import com.moataz.mox.ui.top.TopFragment
import com.moataz.mox.ui.ux.UXFragment

class ArticlesViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TopFragment()
            1 -> ProFragment()
            2 -> AndroidFragment()
            3 -> KotlinFragment()
            else -> UXFragment()
        }
    }
}