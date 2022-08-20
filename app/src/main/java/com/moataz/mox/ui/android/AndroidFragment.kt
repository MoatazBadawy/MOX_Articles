package com.moataz.mox.ui.android

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.moataz.mox.R
import com.moataz.mox.data.api.AndroidService
import com.moataz.mox.data.api.KotlinService
import com.moataz.mox.data.repository.AndroidRepository
import com.moataz.mox.data.repository.KotlinRepository
import com.moataz.mox.databinding.FragmentAndroidBinding
import com.moataz.mox.databinding.FragmentKotlinBinding
import com.moataz.mox.ui.app.adapter.ArticlesAdapter
import com.moataz.mox.utils.status.Recourses
import kotlinx.coroutines.launch

class AndroidFragment : Fragment() {
    private lateinit var binding: FragmentAndroidBinding
    private val adapter = ArticlesAdapter()
    private val repository = AndroidRepository(AndroidService())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAndroidBinding.inflate(layoutInflater)
        initAdapter()
        getArticlesList()
        return binding.root
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initAdapter() {
        binding.recyclerView.setOnTouchListener { _, motionEvent ->
            binding.recyclerView.onTouchEvent(motionEvent)
            true
        }
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun getArticlesList() {
        lifecycleScope.launch {
            repository.getTopList().collect { response ->
                when (response) {
                    is Recourses.Success -> {
                        binding.progressBar.visibility = View.GONE
                        adapter.setData(response.transferredData.items)
                    }
                    is Recourses.Failure -> {
                        Log.e("Error", "NO DATA")
                    }
                    is Recourses.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                }
            }
        }
    }
}