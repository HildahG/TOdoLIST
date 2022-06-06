package com.example.todoapp

import com.example.todoapp.R



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todoapp.Users.User
import com.example.todoapp.Users.UserDatabase
import com.example.todoapp.Users.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main. activity_main.*
import kotlinx.android.synthetic.main.item_todo.*

class MainActivity : AppCompatActivity() {

     lateinit var  todoAdapter: TodoAdapter
     lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        viewModel.readAllData.observe(this, Observer {
            add.setOnClickListener {
                val todoTitle = etTodoTitle.text.toString()
                if (todoTitle.isNotEmpty()) {
                    val todo = Todo(todoTitle)
                    todoAdapter.add(todo)
                    etTodoTitle.text.clear()
                }}

        })

        todoAdapter = TodoAdapter(mutableListOf())

        rvTOdoItem.adapter = todoAdapter
        rvTOdoItem.layoutManager = LinearLayoutManager(this)

//        add.setOnClickListener {
//            val todoTitle = etTodoTitle.text.toString()
//            if (todoTitle.isNotEmpty()) {
//                val todo = Todo(todoTitle)
//                todoAdapter.add(todo)
//                etTodoTitle.text.clear()
//            }}


      delete.setOnClickListener{
            todoAdapter.delete()
    }
    }
}