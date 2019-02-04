package com.wordpress.liliangmader.mylivedatanotepad.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

//Data Access Object, update later with ROOM and SQLite database
class NoteDAO {
    //prepare a database table

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

    fun getNotes() = notes as LiveData<List<Note>>

}