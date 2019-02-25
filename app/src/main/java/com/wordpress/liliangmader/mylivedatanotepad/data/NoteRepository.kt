package com.wordpress.liliangmader.mylivedatanotepad.data

import android.app.Application
import android.os.AsyncTask
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

// abstraction layer between data sources and the rest of the app, SQLite or internet
// best practice, does not have to extend anything
// use primary constructor, constrained, and initialization block
class NoteRepository(private val noteDAO: NoteDAO) {

    // private lateinit var noteDao: NoteDAO
    val allNotes: LiveData<List<Note>> = noteDAO.getAllNotes()

    /** init {
    val notesDatabase = NoteDatabase.getInstance(application)
    noteDao = notesDatabase?.noteDao()!!
    allNotes = noteDao.getAllNotes()
    }**/

    fun getNotes() = allNotes

    //use coroutines
    @WorkerThread
    suspend fun insertNote(note: Note) {
        noteDAO.insertNote(note)
    }

    @WorkerThread
    suspend fun deleteNote(note: Note) {
        noteDAO.deleteNote(note)
    }

    @WorkerThread
    suspend fun updateNote(note: Note) {
        noteDAO.updateNote(note)
    }

    @WorkerThread
    suspend fun deleteAllNotes() {
        noteDAO.deleteAllNotes()
    }
}

    /**
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


    companion object {
        @Volatile
        private var instance: NoteRepository? = null

        fun getInstance(noteDao: NoteDAO) =
            instance ?: synchronized(this) {
                instance ?: NoteRepository(noteDao).also { instance = it }
            }
    }



}
        **/