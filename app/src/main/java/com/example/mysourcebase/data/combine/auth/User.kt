package com.example.mysourcebase.data.combine.auth

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity("users")
data class User(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @ColumnInfo("id")
    val id: Int,
    @SerializedName("user_name")
    @ColumnInfo("user_name")
    val userName: String
)