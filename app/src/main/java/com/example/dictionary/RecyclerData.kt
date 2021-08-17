package com.example.dictionary

import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RecyclerData(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    @Expose
    @SerializedName("word")
    val word: String

)