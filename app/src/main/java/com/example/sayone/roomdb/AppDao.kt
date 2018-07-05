package com.example.sayone.roomdb

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface AppDao {
    // Data Access Object ( DAO ) is a component of ROOM database
    // here is where we write all our queries
    // this function can be used to insert values into the Model Entity class
    @Insert
    fun saveNewMobile(mobile: Mobile)

    // retries list of all the elements from  Mobile table and return a List of Mobile object
    @Query("select * from Mobile")
    fun showAllMobiles():List<Mobile>

    
}