package com.example.todoapp;


import androidx.room.Database;

@Database(entities = [User::class], version = 1)
abstract class  MyDatabase : RoomDatabase() {
abstract fun userDao(): MyDao
        }