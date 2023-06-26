package com.falcon.gymlog_yaka


import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase

abstract  class DBhelper: RoomDatabase() {

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                Log.e("Tag delta : ", "dbHelper ok")
                return tempInstance

            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "AppDatabase"
                ).build()
                INSTANCE = instance
                Log.e("Tag delta : ", "dbHelper ok")
                return instance
            }
        }
    }
}