package com.bobo.mvvmlivedata.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Update

/**
 * This is a generalized interface that take general parameter and make the
 * requested function.
 */

@Dao
interface GenericDao<in T> {

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