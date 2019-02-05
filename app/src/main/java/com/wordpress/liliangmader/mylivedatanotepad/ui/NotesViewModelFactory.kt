package com.wordpress.liliangmader.mylivedatanotepad.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wordpress.liliangmader.mylivedatanotepad.data.NoteRepository

class NotesViewModelFactory(private val noteRepository: NoteRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return NotesViewModel(noteRepository) as T
    }
    
}