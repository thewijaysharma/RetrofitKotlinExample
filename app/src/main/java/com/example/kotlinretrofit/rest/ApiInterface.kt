package com.example.kotlinretrofit.rest

import com.example.kotlinretrofit.model.PostResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface{

    @GET("post/read")
    fun getPosts() : Call<PostResponse>


}