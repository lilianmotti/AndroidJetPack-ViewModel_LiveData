package com.wordpress.liliangmader.mylivedatanotepad.ui

import androidx.lifecycle.ViewModel;
import com.wordpress.liliangmader.mylivedatanotepad.data.Note
import com.wordpress.liliangmader.mylivedatanotepad.data.NoteRepository

class NotesViewModel : ViewModel() {
    private lateinit var noteRepository: NoteRepository

    fun getNotes() = noteRepository.getNotes()

    fun insertNote(note: Note) = noteRepository.insertNote(note)
}
