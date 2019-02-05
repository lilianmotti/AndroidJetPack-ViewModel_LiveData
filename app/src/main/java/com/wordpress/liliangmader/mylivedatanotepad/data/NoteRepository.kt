package com.wordpress.liliangmader.mylivedatanotepad.data

import androidx.lifecycle.LiveData

// abstraction layer between data sources and the rest of the app, SQLite or internet
// best prectice, does not have to extend anything
class NoteRepository private constructor(
    private val noteDao: NoteDAO,
    private val allNotes: LiveData<List<Note>>) {

    fun insertNote(note: Note) {
        noteDao.insertNote(note)
    }

    fun getNotes() = noteDao.getAllNotes()

    companion object {
        @Volatile
        private var instance: NoteRepository? = null

        fun getInstance(noteDao: NoteDAO, allNotes: LiveData<List<Note>>) =
            instance ?: synchronized(this) {
                instance ?: NoteRepository(noteDao,allNotes).also { instance = it }
            }
    }


}

