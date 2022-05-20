package com.example.todoapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
data class MyDatList(
        @PrimaryKey val uid: Int,
        @ColumnInfo(name = "To_do") val title: String?,
        @ColumnInfo(name = "checked") var ischecked: Boolean?,
        )