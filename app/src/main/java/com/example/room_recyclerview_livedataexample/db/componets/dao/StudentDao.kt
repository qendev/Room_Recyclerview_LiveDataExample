package com.example.room_recyclerview_livedataexample.db.componets.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.room_recyclerview_livedataexample.db.componets.entity.Student


@Dao
interface StudentDao {
    @Query("SELECT * FROM studentTbl ORDER BY id ASC")
    fun getAll(): LiveData<List<Student>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(student: Student)
}