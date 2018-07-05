package com.example.sayone.roomdb

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

// this is Database class for ROOM database
//in the entities array list we have to specify all the objects we are creating for this database
// this class should be abstract and should extend Roomdatabse class
@Database(entities = [(Mobile::class)],version = 1)
abstract class Appdb : RoomDatabase() {
    abstract fun mobDao():AppDao
}