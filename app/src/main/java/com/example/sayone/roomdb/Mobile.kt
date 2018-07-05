package com.example.sayone.roomdb

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

// This class works like a table
@Entity
class Mobile {

    //primary key , auto increment is true
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null

    // column info is optional
    @ColumnInfo(name = "type")
    var type:String?=null

    @ColumnInfo(name = "manufacturer")
    var manufacturer:String?=null
    @ColumnInfo(name = "isQuerty")
    var isQuerty:Boolean?=null
}