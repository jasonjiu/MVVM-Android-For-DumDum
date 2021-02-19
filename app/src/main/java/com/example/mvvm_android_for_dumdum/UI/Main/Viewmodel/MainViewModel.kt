package com.example.mvvm_android_for_dumdum.UI.Main.Viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_android_for_dumdum.Data.Model.User
import com.example.mvvm_android_for_dumdum.Data.Repo.MainRepo
import com.example.mvvm_android_for_dumdum.Utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val mainRepo: MainRepo) : ViewModel(){
    private val users = MutableLiveData<Resource<List<User>>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        fetchUsers()
    }

    private fun fetchUsers(){
        users.postValue(Resource.loading(null))
        compositeDisposable.add(
            mainRepo.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    userList -> users.postValue(Resource.success(userList))
                }, {
                    users.postValue(Resource.error("Something wrong", null))
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getUsers(): LiveData<Resource<List<User>>>{
        return users
    }
}