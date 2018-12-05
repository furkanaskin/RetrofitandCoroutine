package com.faskn.retrofitandcoroutine.network

import com.faskn.retrofitandcoroutine.model.Photos
import com.faskn.retrofitandcoroutine.model.Posts
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService{
    @GET("photos")
    fun getPhotos(): Deferred<Response<List<Photos>>>

    @GET("posts")
    fun getPost() : Deferred<Response<List<Posts>>>

}