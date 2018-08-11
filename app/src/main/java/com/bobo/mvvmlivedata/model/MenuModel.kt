package com.bobo.mvvmlivedata.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Creating kotlin data class that will be used to to update UI when a live data object of the class
 * retrieved from data source.
 * @Entity annotation shows that the class name will be the tableName in Room database.
 * and the declared variable name will be used as column name of the database's table
 * tableName param is optional.
 */

@Entity()
data class MenuModel(
        @SerializedName("id")
        @PrimaryKey(autoGenerate = true)
        var id: Int,
        @SerializedName("name")
        var name: String,
        @SerializedName("description")
        var description: String,
        @SerializedName("price")
        var price: String,
        @SerializedName("thumbnail")
        var thumbnail: String)