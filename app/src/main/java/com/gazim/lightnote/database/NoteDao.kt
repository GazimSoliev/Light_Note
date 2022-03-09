package com.gazim.lightnote.database

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao


@Dao
interface NoteDao {

    @Insert
    fun insert(note: Note)

    @Delete
    fun delete(note: Note)

    @Update
    fun update(note: Note)

    @Query("select * from Note")
    fun getAllNotes(): LiveData<List<Note>>

}