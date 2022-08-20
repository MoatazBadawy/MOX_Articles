package com.moataz.mox.ui.top

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.moataz.mox.data.api.TopService
import com.moataz.mox.data.repository.TopRepository
import com.moataz.mox.databinding.FragmentTopBinding
import com.moataz.mox.ui.app.adapter.ArticlesAdapter
import com.moataz.mox.utils.status.Recourses
import kotlinx.coroutines.launch

class TopFragment : Fragment() {
    private lateinit var binding: FragmentTopBinding
    private val adapter = ArticlesAdapter()
    private val repository = TopRepository(TopService())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTopBinding.inflate(layoutInflater)
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
            repository.getTopList().collect {
                when (it) {
                    is Recourses.Success -> {
                        binding.progressBar.visibility = View.GONE
                        adapter.setData(it.transferredData.items)
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