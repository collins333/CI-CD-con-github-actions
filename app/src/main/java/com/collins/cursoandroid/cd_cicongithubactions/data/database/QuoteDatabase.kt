package com.collins.cursoandroid.cd_cicongithubactions.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.collins.cursoandroid.cd_cicongithubactions.data.database.dao.QuoteDao
import com.collins.cursoandroid.cd_cicongithubactions.data.database.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDatabase: RoomDatabase() {
    abstract fun getQuoteDao(): QuoteDao
}