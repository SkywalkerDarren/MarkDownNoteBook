package io.github.skywalkerdarren.markdownnotebook.ui.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import io.github.skywalkerdarren.markdownnotebook.databinding.FragmentNotesBinding
import io.github.skywalkerdarren.markdownnotebook.ui.base.BaseFragment

class NotesFragment : BaseFragment() {

    private val homeViewModel by viewModels<NotesViewModel>()
    private lateinit var binding: FragmentNotesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotesBinding.inflate(layoutInflater, container, false)
        homeViewModel.text.observe(viewLifecycleOwner, ::handleViewState)
        return binding.root
    }

    private fun handleViewState(viewState: NotesViewState) {
        viewState.text?.handleIfNotHandled {
            binding.textHome.text = it
        }
    }
}