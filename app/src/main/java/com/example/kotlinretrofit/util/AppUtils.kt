package com.example.kotlinretrofit.util

import android.view.View
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity

fun <T : View> AppCompatActivity.bind(@IdRes res: Int) : T {
    return findViewById(res)
}

fun AppCompatActivity.toast(msg : String, length : Int = Toast.LENGTH_LONG){
    Toast.makeText(this, msg, length).show()
}