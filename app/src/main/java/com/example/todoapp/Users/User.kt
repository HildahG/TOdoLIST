package com.example.todoapp.Users

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User_data")
data class User (
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val todo: String,
    var ischecked: Boolean,
)