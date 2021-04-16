package com.example.room_recyclerview_livedataexample.db.componets

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.room_recyclerview_livedataexample.db.componets.database.MyDatabse
import com.example.room_recyclerview_livedataexample.db.componets.entity.Student

class StudentViewModel(application: Application):AndroidViewModel(application) {
    private val db:MyDatabse = MyDatabse.getInstance(application)
    internal  val allStudents: LiveData<List<Student>> = db.studentDao().getAll()

    fun insert(student: Student){
        db.studentDao().insert(student)
    }
}