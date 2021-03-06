package com.wordpress.liliangmader.mylivedatanotepad.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

//Data Access Object, updated to ROOM and SQLite database
@Dao
//should be an abstract class or an interface
interface NoteDAO {

    //just define the name, args and return type, and annotate with the database operation
    // room does the rest
    @Insert
    fun insertNote(note: Note):Long

    @Update(onConflict = REPLACE)
    fun updateNote(note: Note): Int

    @Delete
    fun deleteNote(note: Note): Int

    @Query("DELETE FROM note_table")
    fun deleteAllNotes()

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