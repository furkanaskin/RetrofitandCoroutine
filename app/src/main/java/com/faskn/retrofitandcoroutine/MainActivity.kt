package com.faskn.retrofitandcoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.faskn.retrofitandcoroutine.adapters.PhotosAdapter
import com.faskn.retrofitandcoroutine.adapters.PostsAdapter
import com.faskn.retrofitandcoroutine.network.RetrofitFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressbar.visibility = View.VISIBLE

        rv_photos.layoutManager = LinearLayoutManager(this)
        rv_photos.adapter = PhotosAdapter(ArrayList())

        rv_posts.layoutManager = LinearLayoutManager(this)
        rv_posts.adapter = PostsAdapter(ArrayList())

        GlobalScope.launch(Dispatchers.Main) {

            val service = RetrofitFactory.makeRetrofitService()

            val photoRequest = service.getPhotos().await()
            val postRequest = service.getPost().await()

            if (photoRequest.isSuccessful) {
                rv_photos.adapter = PhotosAdapter(photoRequest.body()!!)
            } else {
                Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
            }

            if (postRequest.isSuccessful) {
                rv_posts.adapter = PostsAdapter(postRequest.body()!!)
            } else {
                Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
            }

            progressbar.visibility = View.GONE
        }
    }
}
