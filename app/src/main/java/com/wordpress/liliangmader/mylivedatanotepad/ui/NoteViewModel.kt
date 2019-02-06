package com.wordpress.liliangmader.mylivedatanotepad.ui

import androidx.lifecycle.ViewModel;
import com.wordpress.liliangmader.mylivedatanotepad.data.Note
import com.wordpress.liliangmader.mylivedatanotepad.data.NoteRepository

//viewmodel provider requires a viewmodelfactory
class NoteViewModel(private var noteRepository: NoteRepository) : ViewModel() {
   // private  lateinit var noteRepository: NoteRepository

    fun getNotes() = noteRepository.getNotes()

    fun deleteNotes() = noteRepository.deleteAllNotes()

    fun insertNote(note: Note) = noteRepository.insertNote(note)
}
