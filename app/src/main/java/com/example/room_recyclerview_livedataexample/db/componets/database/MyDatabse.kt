package com.example.room_recyclerview_livedataexample.db.componets.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.room_recyclerview_livedataexample.db.componets.dao.StudentDao
import com.example.room_recyclerview_livedataexample.db.componets.entity.Student

@Database(entities = arrayOf(Student::class),version = 1,exportSchema = false)
abstract class MyDatabse: RoomDatabase() {
    abstract fun studentDao():StudentDao

    companion object{
        private var INSTANCE:MyDatabse? = null
        fun getInstance(context: Context):MyDatabse{
            if(INSTANCE==null){
                INSTANCE= Room.databaseBuilder(
                    context,
                    MyDatabse::class.java,
                    "roomdb")
                    .build()
            }
            return INSTANCE as MyDatabse
        }
    }
}