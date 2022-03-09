package com.gazim.lightnote.ui.action_with_notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.gazim.lightnote.R
import com.gazim.lightnote.database.Note
import com.gazim.lightnote.databinding.FragmentActionWithNotesBinding

class ActionWithNotesFragment : Fragment() {

    private var _binding: FragmentActionWithNotesBinding? = null
    private val binding get() = _binding!!
    private val viewModel by lazy {
        ViewModelProvider(this)[ActionWithNotesViewModel::class.java]
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentActionWithNotesBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init() {
        val any: Any? = arguments?.get("note")
        val actionBtnSave: () -> Unit
        val actionBack = {
            findNavController().navigate(R.id.action_actionWithNotesFragment_to_listNotesFragment)
        }
        if (any != null) {
            val note = any as Note
            binding.etAddTitle.setText(note.title)
            binding.etAddDesc.setText(note.description)
            binding.btnDelete.setOnClickListener {
                actionBack()
                viewModel.delete(note)
            }
            actionBtnSave = {
                note.title = binding.etAddTitle.text.toString()
                note.description = binding.etAddDesc.text.toString()
                viewModel.update(note)
            }
        }
        else {
            binding.btnDelete.visibility = View.GONE
            actionBtnSave = {
                val note = Note(
                    title = binding.etAddTitle.text.toString(),
                    description = binding.etAddDesc.text.toString()
                )
                viewModel.insert(note)
            }
        }
        binding.btnBack.setOnClickListener {
            actionBack()
        }
        binding.btnSave.setOnClickListener{
            actionBack()
            actionBtnSave()
        }
    }

}