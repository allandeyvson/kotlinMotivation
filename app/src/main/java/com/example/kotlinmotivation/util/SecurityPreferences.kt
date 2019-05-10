package com.example.kotlinmotivation.util

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences (context: Context) {

    private val sharedPreferences :  SharedPreferences = context.getSharedPreferences("motivation",  Context.MODE_PRIVATE)


    fun storeString(key : String, value : String){
        sharedPreferences.edit().putString(key, value).apply();
    }

    fun getStoreString(key: String) : String{
        return sharedPreferences.getString(key, "")
    }

}