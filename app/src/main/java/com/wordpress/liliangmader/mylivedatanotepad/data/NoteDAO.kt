package com.wordpress.liliangmader.mylivedatanotepad.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*

//Data Access Object, updated to ROOM and SQLite database
@Dao
//should be an abstract class or an interface
interface NoteDAO {

    @Insert
    abstract fun insertNote(note: Note)

    @Update
    abstract fun updateNote(note: Note)

    @Delete
    abstract fun deleteNote(note: Note)

    @Query("DELETE FROM note_table")
    abstract fun deleteAllNotes()

    //Room can return liveData, so any changes will be notified to the activity
    @Query("SELECT * FROM note_table")
    fun getAllNotes(): LiveData<List<Note>>

   /** previous version, abstract class instead of interface
    //MutableLiveData from Architecture Components Library
    private val noteList = mutableListOf<Note>()

    //LiveData is observed for changes and updates the UI
    private val notes = MutableLiveData<List<Note>>()

    init{
        //connect the noteList
        notes.value = noteList
    }

    fun addNote(note: Note){
        noteList.add(note)
        notes.value = noteList
    }
   **/

}