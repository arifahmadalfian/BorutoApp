package com.arifahmadalfian.borutoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.arifahmadalfian.borutoapp.data.local.dao.HeroDao
import com.arifahmadalfian.borutoapp.data.local.dao.HeroRemoteKeysDao
import com.arifahmadalfian.borutoapp.domain.model.Hero
import com.arifahmadalfian.borutoapp.domain.model.HeroRemoteKeys

@Database(
    entities = [
        Hero::class,
        HeroRemoteKeys::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(DatabaseConverter::class)
abstract class BorutoDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeysDao(): HeroRemoteKeysDao

}