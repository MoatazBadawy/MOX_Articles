package com.moataz.mox.ui.app.view

import android.os.Bundle
import android.view.View.OVER_SCROLL_NEVER
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.moataz.mox.databinding.ActivityMainBinding
import com.moataz.mox.ui.app.adapter.ArticlesViewPagerAdapter
import com.moataz.mox.utils.helper.Views.intiViews

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        initAdapter()
    }

    private fun initView() {
        intiViews(window)
    }

    private fun initAdapter() {
        binding.viewPager.adapter = ArticlesViewPagerAdapter(this)
        binding.viewPager.offscreenPageLimit = 4
        binding.viewPager.overScrollMode = OVER_SCROLL_NEVER
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Top"
                1 -> "Programming"
                2 -> "Android"
                3 -> "Kotlin"
                else -> "UX"
            }
        }.attach()
    }
}