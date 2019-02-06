package com.wordpress.liliangmader.mylivedatanotepad.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wordpress.liliangmader.mylivedatanotepad.data.NoteRepository

//accept one param
class NoteViewModelFactory(private val noteRepository: NoteRepository): ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
      //  return NoteViewModel(noteRepository) as T
        return NoteViewModel(noteRepository) as T
    }


}