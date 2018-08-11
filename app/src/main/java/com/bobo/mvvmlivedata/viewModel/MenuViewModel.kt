package com.bobo.mvvmlivedata.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.bobo.mvvmlivedata.model.MenuModel

class MenuViewModel : ViewModel() {

    private var userId: String? = null
    private var menuList: LiveData<MenuModel>? = null

    fun init(userId: String) {
        this.userId = userId
    }

    fun getMenuList(): LiveData<MenuModel>? {
        return menuList
    }
}