package com.smeonlinetv.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val DATABASE_NAME = "sme_online_tv.db"
    }
}
