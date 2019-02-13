package com.wordpress.liliangmader.mylivedatanotepad.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.wordpress.liliangmader.mylivedatanotepad.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_list_notes.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ListNotesFragment : Fragment() {

    private lateinit var noteViewModel: NoteViewModel
    private lateinit var adapter: NoteListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_list_notes, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.notes_recyclerview)
        adapter = NoteListAdapter(context!!)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context!!)


        val button = view.findViewById<Button>(R.id.button_add)
        button.setOnClickListener {
           // val intent = Intent(this@MainActivity, NewWordActivity::class.java)
           // startActivityForResult(intent, newWordActivityRequestCode)
           Toast.makeText(context,"click", Toast.LENGTH_SHORT).show()
           findNavController().navigate(R.id.action_listNotesFragment_to_addNotesFragment)
       }

        return view
    }

// fragments can be attached and re-attached, calling onCreateView and onAcvtivityCreated again
    //good practice: initialize asynchronous operations as LiveDatain onActivityCreated
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)

      /**  noteViewModel.allNotes.observe(this, Observer { notes ->
            notes?.let {
                adapter.setNotes(it)
            }

        })**/
    }


    /**
     override fun onDestroyView() {
    super.onDestroyView()
    textView = null
     **/

    //  companion object {
    //    const val addNoteFragmentRequestCode = 1
   // }


}
