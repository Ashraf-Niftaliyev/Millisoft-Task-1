package com.example.thirdmonthexam.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.thirdmonthexam.model.UserModel

@Database(entities = [UserModel::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getUserDao():UserDao

}