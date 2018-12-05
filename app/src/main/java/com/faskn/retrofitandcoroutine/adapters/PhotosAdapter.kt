package com.faskn.retrofitandcoroutine.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.faskn.retrofitandcoroutine.holders.PhotosViewHolder
import com.faskn.retrofitandcoroutine.model.Photos


class PhotosAdapter(val photoList : List<Photos>) : RecyclerView.Adapter<PhotosViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        return PhotosViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        holder.bindTo(photoList[position])
    }

}