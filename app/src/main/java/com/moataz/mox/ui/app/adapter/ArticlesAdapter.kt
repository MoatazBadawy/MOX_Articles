package com.moataz.mox.ui.app.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.moataz.mox.R
import com.moataz.mox.data.model.Item
import com.moataz.mox.databinding.ItemArticlesBinding
import com.moataz.mox.utils.helper.Intent.openInBrowser
import com.moataz.mox.utils.helper.Intent.shareArticle

class ArticlesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<Item>? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setData(items: List<Item>?) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ArticlesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_articles,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mediumArticle = items!![position]
        (holder as ArticlesViewHolder).itemArticlesBinding.articleModel = mediumArticle
        holder.setOnClickItem(mediumArticle)
        holder.shareArticleClick(mediumArticle)
    }

    override fun getItemCount(): Int {
        return if (items == null) 0 else items!!.size
    }

    inner class ArticlesViewHolder(var itemArticlesBinding: ItemArticlesBinding) :
        RecyclerView.ViewHolder(
            itemArticlesBinding.root
        ) {

        fun shareArticleClick(article: Item) {
            itemArticlesBinding.shareButtonArticleOnClick.setOnClickListener {
                shareArticle(itemView.context, article)
            }
        }

        fun setOnClickItem(article: Item) {
            itemView.setOnClickListener {
                openInBrowser(itemView.context, article)
            }
        }
    }
}