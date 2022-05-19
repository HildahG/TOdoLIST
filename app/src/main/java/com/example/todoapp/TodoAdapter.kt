package com.example.todoapp

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todo.view.*

class TodoAdapter(
    private val todos:  MutableList<Todo>
) :RecyclerView.Adapter<TodoAdapter.TodoViewholder>() {
    class  TodoViewholder(itemView: View)  :RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewholder {
        return TodoViewholder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_todo,
                parent,
                false
            )
        )

    }
    fun add(todo: Todo){
        todos.add(todo)
        notifyItemInserted(todos.size -1)
    }
    fun  delete(){
        todos.removeAll { todo ->
            todo.ischecked
        }
        notifyDataSetChanged()
    }

    private fun toggleStrikeThrough(textViewtodo: TextView, isChecked: Boolean){
    if(isChecked){
        textViewtodo.paintFlags =textViewtodo.paintFlags or STRIKE_THRU_TEXT_FLAG

    }else {
        textViewtodo.paintFlags = textViewtodo.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
    }
    }

    override fun onBindViewHolder(holder: TodoViewholder, position: Int) {
        val curTodo = todos[position]
        holder.itemView.apply {
             textViewtodo.text =curTodo.title
            check_box1.isChecked = curTodo.ischecked
            toggleStrikeThrough(textViewtodo, curTodo.ischecked)
           check_box1.setOnCheckedChangeListener { _, isChecked ->
             toggleStrikeThrough(textViewtodo, isChecked)
             curTodo.ischecked = !curTodo.ischecked
           }
        }


    }

    override fun getItemCount(): Int {
        return  todos.size

    }
}