package com.wordpress.liliangmader.mylivedatanotepad.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.wordpress.liliangmader.mylivedatanotepad.R
import com.wordpress.liliangmader.mylivedatanotepad.data.Note
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class NoteListAdapter internal constructor(context: Context):
    RecyclerView.Adapter<NoteListAdapter.NoteViewHolder >(){

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var notes = emptyList<Note>()
    var onItemClick: ((Note)->Unit) ?= null

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val noteItemView: TextView = itemView.findViewById(R.id.textView)

        init{
            itemView.setOnClickListener {
                onItemClick?.invoke(notes[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return NoteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val current = notes[position]
        holder.noteItemView.text = current.note_text

    }

    //called inside fragment, OnActivityCreated
    internal fun setNotes(notes: List<Note>) {
        //TODO review this function and content
        this.notes = notes
        notifyDataSetChanged()
    }

    override fun getItemCount() = notes.size


}