package com.bobo.mvvmlivedata.data.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.bobo.mvvmlivedata.model.MenuModel

/*
 * Creating dao (Data Access object) that will handle all the service you will need to interact
 * with the database. Here it is where all the CRUD operation on the database will be mentioned.
 *
 * We implemented the BaseDao interface for generalized function like delete, update and insert as they
 * all take model as parameter
 */

@Dao
interface MenuModelDAO : GenericDao<MenuModel> {
    /*
     * service that Fetch all list of the menu item registered into the database.
     * Query annotation shows what we want to read data from the database
     */
    @Query("SELECT * FROM MenuModel")
    fun getAllMenuItem(): LiveData<List<MenuModel>>

    /*
     * Getting single Menu item data related to the id
     */

    @Query("SELECT * FROM MenuModel where id= :id")
    fun getSingleMenuItem(id: String): MenuModel

}