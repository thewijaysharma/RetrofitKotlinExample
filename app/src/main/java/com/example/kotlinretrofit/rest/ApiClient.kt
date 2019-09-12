package com.example.kotlinretrofit.rest

import com.example.kotlinretrofit.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient{

    val BASE_DEV_URL = "http://178.128.32.180:4011/v1/"
    val BASE_IMG_URL = "http://178.128.32.180:4011/image/"

    @JvmStatic
    fun getWebService(): ApiInterface {



        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = if(BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }

        val httpClient = OkHttpClient().newBuilder().addInterceptor(loggingInterceptor).build()

        val retrofit = Retrofit.Builder()
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_DEV_URL)
            .build()

        return retrofit.create(ApiInterface::class.java)
    }


}


