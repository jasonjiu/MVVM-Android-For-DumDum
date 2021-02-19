package com.example.mvvm_android_for_dumdum.Data.API

import com.example.mvvm_android_for_dumdum.Data.Model.User
import io.reactivex.Single

interface ApiService {
    fun getUsers(): Single<List<User>>
}

