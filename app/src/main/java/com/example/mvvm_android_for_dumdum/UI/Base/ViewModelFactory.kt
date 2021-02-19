package com.example.mvvm_android_for_dumdum.UI.Base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_android_for_dumdum.Data.API.ApiHelper
import com.example.mvvm_android_for_dumdum.Data.Repo.MainRepo
import com.example.mvvm_android_for_dumdum.UI.Main.Viewmodel.MainViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(MainRepo(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown Class Name")
    }

}