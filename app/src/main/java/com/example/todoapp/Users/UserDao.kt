package com.example.todoapp.Users

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun addUser(user: User)

    @Query("SELECT * FROM user ORDER BY uid ASC")
    fun readAllData(): LiveData<List<User>>





}