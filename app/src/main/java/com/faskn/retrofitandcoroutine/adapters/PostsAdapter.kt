package com.faskn.retrofitandcoroutine.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.faskn.retrofitandcoroutine.holders.PostsViewHolder
import com.faskn.retrofitandcoroutine.model.Posts


class PostsAdapter(val postList: List<Posts>) : RecyclerView.Adapter<PostsViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        return PostsViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.bindTo(postList[position])
    }

}