package com.example.room_recyclerview_livedataexample.db.componets.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "studentTbl")
data class Student(
    @PrimaryKey
    var id:Long?,

    @ColumnInfo(name = "uuid")
    var name: String
)