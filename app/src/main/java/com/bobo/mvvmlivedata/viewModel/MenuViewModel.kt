package com.bobo.mvvmlivedata.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.bobo.mvvmlivedata.data.dao.MenuModelDAO
import com.bobo.mvvmlivedata.model.MenuModel


class MenuViewModel : ViewModel() {

    private var menuItemList: LiveData<List<MenuModel>>? = null

    fun getMenuList(menuModelDAO: MenuModelDAO): LiveData<List<MenuModel>> {
        if (menuItemList == null) {
            menuItemList = menuModelDAO.getAllMenuItem()
        }
        return menuItemList!!
    }
}