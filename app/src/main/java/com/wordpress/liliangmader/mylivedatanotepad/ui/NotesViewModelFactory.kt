package com.wordpress.liliangmader.mylivedatanotepad.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wordpress.liliangmader.mylivedatanotepad.data.NoteRepository

class NotesViewModelFactory(private val noteRepository: NoteRepository): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NotesViewModel() as T
    }

}