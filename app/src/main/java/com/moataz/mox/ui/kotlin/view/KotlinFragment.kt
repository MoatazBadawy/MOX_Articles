package com.moataz.mox.ui.kotlin.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.moataz.mox.data.model.ArticleResponse
import com.moataz.mox.databinding.FragmentKotlinBinding
import com.moataz.mox.ui.app.adapter.ArticlesAdapter
import com.moataz.mox.ui.kotlin.viewmodel.KotlinViewModel
import com.moataz.mox.utils.status.Recourses

class KotlinFragment : Fragment() {
    private lateinit var binding: FragmentKotlinBinding
    private val adapter = ArticlesAdapter()
    private val viewModel: KotlinViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKotlinBinding.inflate(layoutInflater)
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
        viewModel.mediumObjectsList.observe(requireActivity()) { response: Recourses<ArticleResponse> ->
            when (response) {
                is Recourses.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Recourses.Success -> {
                    binding.progressBar.visibility = View.GONE
                    adapter.setData(response.transferredData.items)
                }
                is Recourses.Failure -> {
                    binding.progressBar.visibility = View.GONE
                }
            }
        }
    }
}