package com.example.dictionary.database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities= arrayOf(FavoriteListData::class),version = 1)
abstract class FavoriteDatabase : RoomDatabase(){
    abstract fun favoriteDao(): FavoriteDao

}


