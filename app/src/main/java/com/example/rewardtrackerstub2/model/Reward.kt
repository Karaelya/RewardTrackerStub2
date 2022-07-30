package com.example.rewardtrackerstub2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "partner")
data class Partner (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name = "guyFirst")
    val guyFirst: String,
    @ColumnInfo(name = "guyLast")
    val guyLast: String,
    @ColumnInfo(name = "girlFirst")
    val girlFirst: String,
    @ColumnInfo(name = "girlLast")
    val girlLast: String
    )

data class PartnerDetails (
    val guyFirst: String,
    val guyLast: String,
    val girlFirst: String,
    val girlLast: String
        )