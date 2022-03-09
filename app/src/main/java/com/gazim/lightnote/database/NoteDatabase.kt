package com.gazim.lightnote.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase: RoomDatabase() {

    abstract fun getNotesDao(): NoteDao

    companion object {
        lateinit var noteDatabase: NoteDatabase
    }
}