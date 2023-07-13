package com.example.mysourcebase.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mysourcebase.data.combine.auth.User
import com.example.mysourcebase.data.source.local.auth.AuthDao

@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)
abstract class MyDatabase : RoomDatabase() {
    abstract fun authDao(): AuthDao
}