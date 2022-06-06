package com.example.todoapp.Users

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
//data class User (
//    @PrimaryKey(autoGenerate = true)
//    val id : Int,val
////    var ischecked
//    : Boolean,
//)
///@Entity
data class User(
        @PrimaryKey (autoGenerate = true)
        val uid: Int,
         val title: String?,
        val ischecked: Boolean?,
        )