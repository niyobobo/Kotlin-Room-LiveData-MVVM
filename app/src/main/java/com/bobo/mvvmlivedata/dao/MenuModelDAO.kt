package com.bobo.mvvmlivedata.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.bobo.mvvmlivedata.model.MenuModel

@Dao
interface MenuModelDAO {
    @Query("SELECT * FROM MenuModel")
    fun getAllMenu(): LiveData<List<MenuModel>>


}