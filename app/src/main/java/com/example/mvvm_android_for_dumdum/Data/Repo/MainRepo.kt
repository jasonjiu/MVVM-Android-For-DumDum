package com.example.mvvm_android_for_dumdum.Data.Repo

import com.example.mvvm_android_for_dumdum.Data.API.ApiHelper
import com.example.mvvm_android_for_dumdum.Data.Model.User
import io.reactivex.Single

class MainRepo(private val apiHelper: ApiHelper) {
    fun getUsers(): Single<List<User>>{
        return apiHelper.getUsers()
    }
}