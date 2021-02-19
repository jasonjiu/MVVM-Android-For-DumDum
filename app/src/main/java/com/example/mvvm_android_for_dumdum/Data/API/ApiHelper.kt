package com.example.mvvm_android_for_dumdum.Data.API

class ApiHelper (private val apiService: ApiService){
    fun getUsers() = apiService.getUsers()
}