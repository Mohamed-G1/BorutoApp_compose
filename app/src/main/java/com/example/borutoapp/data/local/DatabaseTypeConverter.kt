package com.example.borutoapp.data.local

import androidx.room.TypeConverter


class DatabaseTypeConverter {
    private val separator = ","

    @TypeConverter
    fun convertListToString(stingList: List<String>): String {
        val stringBuilder = StringBuilder().also { stingBuilder ->
            for (item in stingList) {
                stingBuilder.append(separator)
            }
            //This line to automatically doesn't add a separator after the last string
            stingBuilder.setLength(stingBuilder.length - separator.length)
        }
        return stringBuilder.toString()
    }

    @TypeConverter
    fun convertStringToList(string: String): List<String> {
        return string.split(separator)
    }


}