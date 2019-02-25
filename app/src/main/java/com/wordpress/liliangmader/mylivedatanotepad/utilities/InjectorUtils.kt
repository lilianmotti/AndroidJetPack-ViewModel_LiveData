package com.wordpress.liliangmader.mylivedatanotepad.utilities

object InjectorUtils {

     /** initiated inside viewmodel instead
    fun provideNotesViewModelFactory(application: Application): NoteViewModelFactory {
        val context = application.applicationContext
         val noteRepository = NoteRepository.getInstance(NoteDatabase.getInstance(context)!!.noteDao())
        return NoteViewModelFactory(noteRepository)
    }
**/
}