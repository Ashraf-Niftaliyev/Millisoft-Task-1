package com.example.thirdmonthexam.roomdb

import android.content.Context
import androidx.room.Room
import com.example.thirdmonthexam.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppProvider(var context: Context){
    val database = Room
        .databaseBuilder(context,AppDatabase::class.java,"app_database")
        .build()

     private fun getDao() = database.getUserDao()

    suspend fun getAllUsers() = withContext(Dispatchers.IO){
        getDao().getAllUsers()
    }

    suspend fun getAllUsersEmail(e:String,p:String) = withContext(Dispatchers.IO){
        getDao().getAllUsersEmail(e,p)
    }

    suspend fun insertUser(user: UserModel) = withContext(Dispatchers.IO){
        getDao().insertUser(user)
    }

    suspend fun deleteUser(user: UserModel) = withContext(Dispatchers.IO){
        getDao().deleteUser(user)
    }
}