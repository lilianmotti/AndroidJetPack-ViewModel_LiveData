package com.wordpress.liliangmader.mylivedatanotepad.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.wordpress.liliangmader.mylivedatanotepad.data.Note
import com.wordpress.liliangmader.mylivedatanotepad.data.NoteDatabase
import com.wordpress.liliangmader.mylivedatanotepad.data.NoteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

//viewmodel provider can use a viewmodelfactory
//NoteViewModel has to have zero argument constructor
class NoteViewModel(application: Application): AndroidViewModel(application) {

    private var parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)


    private  var noteRepository: NoteRepository
    val allNotes: LiveData<List<Note>>

    init {
        val noteDao = NoteDatabase.getInstance(application,scope).noteDao()
        noteRepository = NoteRepository(noteDao)
        allNotes = noteRepository.allNotes
    }
   // fun getNotes() = noteRepository.getNotes()

  //  fun insertNote(note: Note) = noteRepository.insertNote(note)

    fun insertNote(note:Note) = scope.launch(Dispatchers.IO) {
        noteRepository.insertNote(note)
    }

    fun updateNote(note:Note) = scope.launch(Dispatchers.IO) {
        noteRepository.updateNote(note)
    }

    fun deleteNote(note:Note) = scope.launch(Dispatchers.IO) {
        noteRepository.deleteNote(note)
    }

    fun deleteAllNotes() = scope.launch(Dispatchers.IO) {
        noteRepository.deleteAllNotes()
    }

    fun getAllNotes(allNotes: LiveData<List<Note>>) = allNotes

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }
}
