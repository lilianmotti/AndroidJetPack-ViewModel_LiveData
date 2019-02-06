package com.wordpress.liliangmader.mylivedatanotepad.data

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData

// abstraction layer between data sources and the rest of the app, SQLite or internet
// best practice, does not have to extend anything
// use primary constructor, constrained, and initialization block
class NoteRepository(application: Application) {

    private val noteDao: NoteDAO
    private val allNotes: LiveData<List<Note>>

    init {
        val notesDatabase = NoteDatabase.getInstance(application)
        noteDao = notesDatabase?.noteDao()!!
        allNotes = noteDao.getAllNotes()
    }

    fun getNotes() = allNotes

    fun insertNote(note: Note) {
       //not noteDao.insertNote(note), use async instead
        InsertNoteAsync(noteDao).execute(note)
    }

    fun deleteAllNotes() {
        //not noteDao.insertNote(note), use async instead
        DeleteAllNotesAsync(noteDao).execute()
    }


    //create multiple async class, public and static to avoid memory leaks
    private class InsertNoteAsync internal constructor
        (private val mAsyncNoteDao: NoteDAO) : AsyncTask<Note, Void, Void>() {

        override fun doInBackground(vararg params: Note): Void? {
            mAsyncNoteDao.insertNote(params[0])
            return null
        }
    }

    private class DeleteAllNotesAsync internal constructor
        (private val mAsyncNoteDao: NoteDAO) : AsyncTask<Void, Void, Void>() {

        override fun doInBackground(vararg p0: Void?): Void? {
                    //(vararg params: Note): Void? {
            mAsyncNoteDao.deleteAllNotes()
            return null
        }
    }

    /**
    companion object {
        @Volatile
        private var instance: NoteRepository? = null

        fun getInstance(noteDao: NoteDAO, allNotes: LiveData<List<Note>>) =
            instance ?: synchronized(this) {
                instance ?: NoteRepository().also { instance = it }
            }
    }

    **/

}

