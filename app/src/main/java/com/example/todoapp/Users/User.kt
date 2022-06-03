package com.example.todoapp.Users

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
//data class User (
//    @PrimaryKey(autoGenerate = true)
//    val id : Int,
//    val todo: String,
//    var ischecked: Boolean,
//)
///@Entity
data class User(
        @PrimaryKey val uid: Int,
        @ColumnInfo(name = "To_do") val title: String?,
        @ColumnInfo(name = "checked") var ischecked: Boolean?,
        )