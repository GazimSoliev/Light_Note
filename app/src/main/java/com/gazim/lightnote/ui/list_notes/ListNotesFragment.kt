package com.gazim.lightnote.ui.list_notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.gazim.lightnote.R
import com.gazim.lightnote.database.Note
import com.gazim.lightnote.databinding.FragmentListNotesBinding

class ListNotesFragment : Fragment() {

    private var _binding: FragmentListNotesBinding? = null
    private val binding get() = _binding!!
    private val viewModel by lazy {
        ViewModelProvider(this)[ListNotesViewModel::class.java]
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListNotesBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init() {
        val adapter = ListNotesAdapter(this)
        binding.rvListNotes.adapter = adapter
        viewModel.listLiveData.observe(viewLifecycleOwner) {
            adapter.listNotes = it
        }
        binding.fBtnAddNote.setOnClickListener {
            findNavController().navigate(R.id.action_listNotesFragment_to_actionWithNotesFragment)
        }
    }

    fun onClickHolder(note: Note) {
        val bundle = Bundle()
        bundle.putSerializable("note", note)
        findNavController().navigate(R.id
            .action_listNotesFragment_to_actionWithNotesFragment, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}