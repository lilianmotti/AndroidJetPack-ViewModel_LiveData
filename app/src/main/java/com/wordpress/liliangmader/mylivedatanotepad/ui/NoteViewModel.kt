package com.wordpress.liliangmader.mylivedatanotepad.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.wordpress.liliangmader.mylivedatanotepad.data.Note
import com.wordpress.liliangmader.mylivedatanotepad.data.NoteDatabase
import com.wordpress.liliangmader.mylivedatanotepad.data.NoteRepository

//viewmodel provider requires a viewmodelfactory
//NoteViewModel> has to have zero argument constructor
class NoteViewModel(application: Application) : ViewModel() {
    //
    private  lateinit var noteRepository: NoteRepository
    val allNotes: LiveData<List<Note>>

    init {
        val noteDao = NoteDatabase.getInstance(application)!!.noteDao()
        noteRepository = NoteRepository(noteDao)
        allNotes = noteRepository.allNotes
    }
    fun getNotes() = noteRepository.getNotes()

    fun deleteNotes() = noteRepository.deleteAllNotes()

    fun insertNote(note: Note) = noteRepository.insertNote(note)
}
