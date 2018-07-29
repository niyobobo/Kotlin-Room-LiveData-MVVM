package com.bobo.mvvmlivedata.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class MenuModel(
        @PrimaryKey(autoGenerate = true)
        var itemId: String,
        var itemName: String,
        var itemDescription: String,
        var itemprice: String)