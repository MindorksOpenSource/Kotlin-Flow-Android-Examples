package com.mindorks.kotlinFlow.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mindorks.kotlinFlow.data.local.entity.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAll(): Flow<List<User>>

    @Insert
    fun insertAll(users: List<User>)

    @Delete
    fun delete(user: User)

}