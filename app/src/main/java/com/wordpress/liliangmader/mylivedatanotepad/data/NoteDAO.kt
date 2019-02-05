package com.wordpress.liliangmader.mylivedatanotepad.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

//Data Access Object, updated to ROOM and SQLite database
@Dao
//should be an abstract class or an interface
interface NoteDAO {
    //prepare a database table

    @Query("SELECT * FROM note_table")
    fun getNotes() = notes as LiveData<List<Note>>


    @Insert
    fun insertNotes(note: Note)


    /**previous version
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