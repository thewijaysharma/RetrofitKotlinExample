package com.example.kotlinretrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinretrofit.R
import com.example.kotlinretrofit.model.PostResponse
import com.example.kotlinretrofit.rest.ApiClient
import com.example.kotlinretrofit.util.toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), RecyclerAdapter.TouchCallback {


    override fun onItemTouched(post: PostResponse.Data) {
        toast("item clicked with name ${post.fullName}")
    }

    val postList : ArrayList<PostResponse.Data> = ArrayList()
    val adapter: RecyclerAdapter = RecyclerAdapter(postList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val apiService = ApiClient.getWebService()
        apiService.getPosts().enqueue( object : Callback<PostResponse>{
            override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                progressBar.visibility = View.GONE
                toast("Something went wrong")
            }

            override fun onResponse(call: Call<PostResponse>, response: Response<PostResponse>) {
                progressBar.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
                toast("Posts fetched successfully")
                postList.clear()
                response.body()?.data?.let { postList.addAll(it) }
                adapter.notifyDataSetChanged()
            }

        })

    }

}


