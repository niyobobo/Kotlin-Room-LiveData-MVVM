package com.bobo.mvvmlivedata.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
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