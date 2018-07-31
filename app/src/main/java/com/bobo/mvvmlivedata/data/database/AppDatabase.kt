package com.bobo.mvvmlivedata.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.bobo.mvvmlivedata.data.dao.MenuModelDAO
import com.bobo.mvvmlivedata.model.MenuModel

/**
 * Creating an abstract class that extends RoomDatabase class
 * This class helps you to make an instance of the application database so that it can initiate it on
 * the start of the application.
 *
 * @Database annotation describes that this class will initiate the database and it takes two parameter
 * -    array of entities(Model classes that define the column of your database)
 * -    The version of your database
 *
 */

@Database(entities = [(MenuModel::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {

    private var instance: AppDatabase? = null

    /**
     * Returning instance of the database; we initialise object of the class to the Room.databaseBuilder
     * where Database builder take 3 parameters which are:
     * -    The context of the application
     * -    Database class name
     * -    and The name you want to call your database.
     */

    fun getDatabase(context: Context): AppDatabase {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "menu_db").build()
        }
        return instance as AppDatabase
    }

    /**
     * TIP:
     * We have to create an abstract method for every DAO class that we create.
     * Those functions Help to access the DAO services through the instance of the AppDatabase class
     *
     */

    abstract fun getMenuModelDao(): MenuModelDAO
}