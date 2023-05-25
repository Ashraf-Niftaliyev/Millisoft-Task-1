package com.example.thirdmonthexam.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("user_table")
data class UserModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var email: String,
    var password: String
)
