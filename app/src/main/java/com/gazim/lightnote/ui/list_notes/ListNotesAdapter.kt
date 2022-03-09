package com.gazim.lightnote.ui.list_notes

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gazim.lightnote.R
import com.gazim.lightnote.database.Note

class ListNotesAdapter(private val fragment: ListNotesFragment):
    RecyclerView.Adapter<ListNotesAdapter.ViewHolder>() {

    var listNotes = emptyList<Note>()
    @SuppressLint("NotifyDataSetChanged")
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.tv_item_title).text = listNotes[position].title
        holder.itemView.findViewById<TextView>(R.id.tv_item_description).text = listNotes[position].description
        holder.itemView.setOnClickListener {
            fragment.onClickHolder(listNotes[position])
        }
    }

    override fun getItemCount(): Int = listNotes.size
}

