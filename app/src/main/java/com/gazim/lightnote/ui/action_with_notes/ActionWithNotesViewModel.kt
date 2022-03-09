package com.gazim.lightnote.ui.action_with_notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gazim.lightnote.database.Note
import com.gazim.lightnote.database.NoteDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ActionWithNotesViewModel: ViewModel() {
    private val dao = NoteDatabase.noteDatabase.getNotesDao()

    fun insert(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(note)
        }
    }

    fun delete(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.delete(note)
        }
    }

    fun update(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.update(note)
        }
    }
}