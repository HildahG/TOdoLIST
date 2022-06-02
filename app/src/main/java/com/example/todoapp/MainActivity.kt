package com.example.todoapp

import com.example.todoapp.R



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main. activity_main.*
import kotlinx.android.synthetic.main.item_todo.*

class MainActivity : AppCompatActivity() {

    private  lateinit var  todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Room.databaseBuilder(
            applicationContext,
            RoomDatabase::class.java, "CheckList"
        ).build()

        todoAdapter = TodoAdapter(mutableListOf())

        rvTOdoItem.adapter = todoAdapter
        rvTOdoItem.layoutManager = LinearLayoutManager(this)

        add.setOnClickListener {
            val todoTitle = etTodoTitle.text.toString()
            if (todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.add(todo)
                etTodoTitle.text.clear()


            }
        }
        delete.setOnClickListener{
            todoAdapter.delete()
    }
    }
}