package com.example.kotlinretrofit.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinretrofit.R
import com.example.kotlinretrofit.model.PostResponse
import com.example.kotlinretrofit.rest.ApiClient
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.row_recycler.view.*
import java.lang.StringBuilder




class RecyclerAdapter(private val postList : List<PostResponse.Data>, private val callback : TouchCallback) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>(){

    private lateinit var context : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        context = parent.context
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.row_recycler, parent, false)
        return MyViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val postData = postList[position]
        Glide.with(context).load(ApiClient.BASE_IMG_URL+postData.userPic).into(holder.circleImg)

        if(postData.thumbnail.isNotEmpty()){
            Glide.with(context).load(ApiClient.BASE_IMG_URL+postData.thumbnail).into(holder.mainImg)
        }

        val stringBuilder = StringBuilder()

        for (tag in postData.hashtags){
            stringBuilder.append("#").append(tag.name).append(" ")
        }

        holder.tags.text  = stringBuilder
        holder.name.text = postData.fullName
        holder.countText.text = postData.commentCount

        holder.itemView.setOnClickListener{
            callback.onItemTouched(postData)
        }

    }


    class MyViewHolder(v : View) : RecyclerView.ViewHolder(v){

        val name: TextView = v.nameText
        val mainImg: ImageView = v.mainImg
        val circleImg: CircleImageView = v.circleImg
        val countText: TextView = v.likeCount
        val tags: TextView = v.hashtags


    }

    interface TouchCallback {
        fun onItemTouched(post : PostResponse.Data)
    }

}