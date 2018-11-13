package com.bobo.mvvmlivedata.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bobo.mvvmlivedata.data.dao.MenuModelDAO
import com.bobo.mvvmlivedata.model.MenuModel

/**
 * Creating an abstract class that extends RoomDatabase class
 * This class helps you to make an instance of the application database
 * so that it can be initiated on the start of the application.
 *
 * @Database annotation describes that this class will initiate the database and it takes two parameter
 * -    array of entities(Model classes that define the column of your database)
 * -    The version of your database
 *
 */

@Database(entities = [(MenuModel::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {
    /**
     * TIP:
     * We have to create an abstract method for every created DAO interface .
     * Those functions Help to access the DAO services through the instance of the AppDatabase class
     *
     */

    abstract fun getMenuModelDao(): MenuModelDAO
}