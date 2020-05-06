package com.mindorks.kotlinFlow.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mindorks.kotlinFlow.data.local.dao.UserDao
import com.mindorks.kotlinFlow.data.local.entity.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}