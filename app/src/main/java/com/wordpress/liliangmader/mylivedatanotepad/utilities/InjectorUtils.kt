package com.wordpress.liliangmader.mylivedatanotepad.utilities

import android.content.Context
import com.wordpress.liliangmader.mylivedatanotepad.data.NoteDatabase
import com.wordpress.liliangmader.mylivedatanotepad.data.NoteRepository
import com.wordpress.liliangmader.mylivedatanotepad.ui.NotesViewModelFactory

object InjectorUtils {
    /**
    fun provideNotesViewModelFactory():NotesViewModelFactory {
        val noteRepository = NoteRepository
            .getInstance(NoteDatabase.getInstance().noteDao())
        return NotesViewModelFactory(noteRepository)
    }
    **/
}