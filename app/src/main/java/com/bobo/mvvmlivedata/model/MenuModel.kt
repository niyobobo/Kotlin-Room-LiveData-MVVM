package com.bobo.mvvmlivedata.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Creating kotlin data class that will be used to to update UI when a live data object of the class
 * retrieved from data source.
 * @Entity annotation shows that the class name will be the tableName in Room database.
 * and the declared variable name will be used as column name of the database's table
 * tableName param is optional.
 */

@Entity(tableName = "menuModel")
data class MenuModel(
        @PrimaryKey(autoGenerate = true)
        var itemId: String,
        var itemName: String,
        var itemDescription: String,
        var itemPrice: String)