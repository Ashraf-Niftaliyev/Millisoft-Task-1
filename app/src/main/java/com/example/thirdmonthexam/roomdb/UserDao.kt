package com.example.thirdmonthexam.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.thirdmonthexam.model.UserModel

@Dao
interface UserDao {

    @Query("Select * From user_table")
    suspend fun getAllUsers():List<UserModel>

    @Query("Select * From user_table Where email= :e and password= :p")
    suspend fun getAllUsersEmail(e: String,p: String): List<UserModel>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: UserModel)

    @Delete
    suspend fun deleteUser(user: UserModel)


}