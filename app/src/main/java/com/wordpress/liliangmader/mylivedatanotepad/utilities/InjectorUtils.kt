package com.wordpress.liliangmader.mylivedatanotepad.utilities

import android.app.Application
import com.wordpress.liliangmader.mylivedatanotepad.data.NoteDatabase
import com.wordpress.liliangmader.mylivedatanotepad.data.NoteRepository
import com.wordpress.liliangmader.mylivedatanotepad.ui.NoteViewModelFactory

object InjectorUtils {

     /** initiated inside viewmodel instead
    fun provideNotesViewModelFactory(application: Application): NoteViewModelFactory {
        val context = application.applicationContext
         val noteRepository = NoteRepository.getInstance(NoteDatabase.getInstance(context)!!.noteDao())
        return NoteViewModelFactory(noteRepository)
    }
**/
}