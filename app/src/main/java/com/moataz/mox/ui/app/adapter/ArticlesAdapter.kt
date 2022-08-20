package com.moataz.mox.ui.app.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.moataz.mox.R
import com.moataz.mox.data.model.Item

class ArticlesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<Item>? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setData(items: List<Item>?) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ArticlesViewHolder(inflater.inflate(R.layout.item_articles, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mediumArticle = items!![position]
        (holder as ArticlesViewHolder).setData(mediumArticle)
        holder.setOnClickItem(mediumArticle)
        holder.shareArticle(mediumArticle)
    }

    override fun getItemCount(): Int {
        return if (items == null) 0 else items!!.size
    }

    internal class ArticlesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val image: ImageView
        private val title: TextView
        private val source: TextView
        private val author: TextView
        private val share: Button
        private val saveButton: ImageButton
        private val activity = Activity()

        fun setData(mediumArticle: Item) {
            Glide.get(itemView.context).clearMemory()
            // load images in MainThread
            activity.runOnUiThread {
                Glide.with(itemView.context)
                    .load(mediumArticle.thumbnail)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .skipMemoryCache(true)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(image)
                Glide.get(itemView.context).clearMemory()
            }
            title.text = mediumArticle.title
            source.setText(R.string.medium)
            author.text = mediumArticle.author
        }

        fun shareArticle(news: Item) {
            share.setOnClickListener { v: View ->
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                val shareSubText =
                    """
                   Check out this great article from *MOX APP*
                   
                   """.trimIndent()
                val shareBodyText = shareSubText + news.link
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubText)
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareBodyText)
                v.context.startActivity(Intent.createChooser(shareIntent, "Share With"))
            }
        }

        /**
         * When the user click on article it will open the article
         * in new Tab using ChromeCustomTab
         */
        fun setOnClickItem(article: Item) {
            itemView.setOnClickListener { v: View? ->
                val customTabIntent = CustomTabsIntent.Builder()
                customTabIntent.setToolbarColor(Color.parseColor("#ffffff"))
                customTabIntent.setStartAnimations(
                    itemView.context,
                    R.anim.slide_in_right,
                    R.anim.slide_out_left
                )
                customTabIntent.setExitAnimations(
                    itemView.context,
                    R.anim.slide_in_left,
                    R.anim.slide_out_right
                )
                customTabIntent.setShowTitle(true)
                openCustomTabs(
                    itemView.context,
                    customTabIntent.build(),
                    Uri.parse(article.link)
                )
            }
        }

        private fun openCustomTabs(
            activity: Context?,
            customTabsIntent: CustomTabsIntent,
            uri: Uri?
        ) {
            val packageName = "com.android.chrome"
            customTabsIntent.intent.setPackage(packageName)
            customTabsIntent.launchUrl(activity!!, uri!!)
        }

        init {
            image = itemView.findViewById(R.id.image_article)
            title = itemView.findViewById(R.id.title_article)
            source = itemView.findViewById(R.id.source_article)
            author = itemView.findViewById(R.id.author_name_article)
            share = itemView.findViewById(R.id.share_button_article_onClick)
            saveButton = itemView.findViewById(R.id.save_button_article_list)
        }
    }

}