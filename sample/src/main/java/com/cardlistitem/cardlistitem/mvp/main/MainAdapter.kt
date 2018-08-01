package com.cardlistitem.cardlistitem.mvp.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.cardlistitem.cardlistitem.R
import com.cardlistitem.cardlistitem.model.Post
import kotlinx.android.synthetic.main.list_post.view.*
import java.util.*

class MainAdapter(private var context: Context) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var posts: ArrayList<Post>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = MainViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.list_post, parent, false))

    override fun getItemCount() = if (posts == null) 0 else posts!!.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.onBind(position)
    }

    fun setPostList(posts: ArrayList<Post>?) {
        this.posts = posts
        notifyDataSetChanged()
    }


    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun onBind(position: Int) {
            inflateData(posts?.get(position))
        }

        private fun inflateData(post: Post?) {
            post.let {
                val timeUploaded = java.lang.Long.valueOf(it?.timeUploaded)
                val timeCompare = DateUtils.getRelativeTimeSpanString(timeUploaded,
                        System.currentTimeMillis(), 0) as String

                itemView.card_list_item.headerToolbar.menu.clear()
                itemView.card_list_item.headerToolbar.inflateMenu(R.menu.menu_post)
                Glide.with(context).load(it?.user?.image).into(itemView.card_list_item.headerImageView)
                itemView.card_list_item.headerTitle = it?.user?.name
                Glide.with(context).load(it?.contentImage).into(itemView.card_list_item.contentImageView)
                itemView.card_list_item.contentTitle = it?.contentTitle
                itemView.card_list_item.contentShortDescription = it?.contentDescription
                itemView.card_list_item.timestamp = timeCompare
            }
        }

    }

}