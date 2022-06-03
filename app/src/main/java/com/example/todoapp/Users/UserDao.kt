package com.example.todoapp.Users

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAll() : List<User>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM user WHERE to_do LIKE :first AND " +
            "checked LIKE :last LIMIT 1")
    fun findByName(first: String, last: Boolean): User

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)
}