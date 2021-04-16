package com.example.room_recyclerview_livedataexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.room_recyclerview_livedataexample.R
import com.example.room_recyclerview_livedataexample.db.componets.StudentViewModel
import com.example.room_recyclerview_livedataexample.db.componets.entity.Student
import com.example.room_recyclerview_livedataexample.ui.adapter.MyRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var model: StudentViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the view model
        model = ViewModelProviders.of(this).get(StudentViewModel::class.java)

        // Specify layout for recycler view
        val linearLayoutManager = LinearLayoutManager(
            this, RecyclerView.VERTICAL,false)
        myRecyclerView.layoutManager = linearLayoutManager

        // Observe the model
        model.allStudents.observe(this, Observer{ students->
            // Data bind the recycler view
            myRecyclerView.adapter = MyRecyclerViewAdapter(students)
        })

        // Insert data into table
        btn.setOnClickListener {
            doAsync {
                model.insert(Student(null, UUID.randomUUID().toString()))
            }
        }
    }
}