package com.gazim.lightnote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.gazim.lightnote.database.NoteDatabase
import com.gazim.lightnote.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        NoteDatabase.noteDatabase = Room.databaseBuilder(
            applicationContext, NoteDatabase::class.java, "db").build()
        setContentView(binding.root)
    }
}