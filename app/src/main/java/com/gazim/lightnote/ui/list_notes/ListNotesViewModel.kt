package com.gazim.lightnote.ui.list_notes

import androidx.lifecycle.ViewModel
import com.gazim.lightnote.database.NoteDatabase

class ListNotesViewModel: ViewModel() {
    val listLiveData = NoteDatabase.noteDatabase
        .getNotesDao().getAllNotes()
}