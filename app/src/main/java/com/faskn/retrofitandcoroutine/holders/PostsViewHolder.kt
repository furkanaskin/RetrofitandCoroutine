package com.faskn.retrofitandcoroutine.holders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.faskn.retrofitandcoroutine.R
import com.faskn.retrofitandcoroutine.model.Posts

class PostsViewHolder(viewGroup: ViewGroup) :
    RecyclerView.ViewHolder(
        LayoutInflater.from(viewGroup.context).inflate(
            R.layout.items,
            viewGroup,
            false
        )
    ) {

    private val txtTitle by lazy { itemView.findViewById<TextView>(R.id.tv_title) }

    fun bindTo(posts: Posts) {
        txtTitle.text = posts.body
    }
}