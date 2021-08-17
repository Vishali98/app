package com.example.dictionary.database


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favoritelistData")
data class FavoriteListData(
    @PrimaryKey
    var id: Int=0,

    @ColumnInfo(name = "word")
    var word: String? = null

)