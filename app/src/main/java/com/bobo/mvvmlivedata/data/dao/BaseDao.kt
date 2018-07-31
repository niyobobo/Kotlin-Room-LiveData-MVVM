package com.bobo.mvvmlivedata.data.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Update

/**
 * This is a generalized interface that take general parameter and make the
 * requested function.
 */

@Dao
interface BaseDao<in T> {

    /*
    * In case there is conflicts during insert manipulation operations, we have to specify
    * a conflict strategy too. In our example, we are using REPLACE.
    * It means that the conflicting entry will be replaced by the current entry.
    */

    @Insert(onConflict = REPLACE)
    fun insert(t: T)

    @Update
    fun update(t: T)

    @Delete
    fun delete(t: T)
}